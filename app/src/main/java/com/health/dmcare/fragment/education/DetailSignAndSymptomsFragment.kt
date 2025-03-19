package com.health.dmcare.fragment.education

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.health.dmcare.util.OnlineCheckerHelper.isOnline
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.health.dmcare.R
import com.health.dmcare.adapter.StaggeredAdapter
import com.health.dmcare.databinding.FragmentDetailSignAndSymptomsBinding
import com.health.dmcare.models.DataCardDiabetes
import com.health.dmcare.util.GenerateData
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class DetailSignAndSymptomsFragment : Fragment() {
    private var _binding: FragmentDetailSignAndSymptomsBinding? = null
    private val binding get() = _binding!!

    private lateinit var youTubePlayer: YouTubePlayerView
    private lateinit var thumbnailCardView: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailSignAndSymptomsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        youTubePlayer = binding.pvDetailSignAndSymptoms
        thumbnailCardView = binding.thumbnailOfflineDetailSignAndSymptoms

        val items = GenerateData.detailTandaGejalaDiabetes()

        setupToolbar()
        setupRecyclerView(items)
        setupPlayerVideoWithOfflineCallback()
        statusBarSetup()
    }

    private fun setupRecyclerView(items: List<DataCardDiabetes>) {
        val adapter = StaggeredAdapter(items)
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.rvDetailSignAndSymptoms.layoutManager = layoutManager
        binding.rvDetailSignAndSymptoms.adapter = adapter
    }

    @Suppress("DEPRECATION")
    private fun statusBarSetup() {
        requireActivity().window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            statusBarColor = ContextCompat.getColor(requireContext(), R.color.blue)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }

    private fun setupToolbar() {
        val toolbar = binding.toolbar
        toolbar.isTitleCentered = true
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_ios_new_24)
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupPlayerVideoWithOfflineCallback() {
        if (isOnline(requireContext())) {
            youTubePlayer.visibility = View.VISIBLE
            thumbnailCardView.visibility = View.GONE

            lifecycle.addObserver(youTubePlayer)

            youTubePlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = getString(R.string.symptom_video_id)
                    youTubePlayer.cueVideo(videoId, 0f)
                }
            })
        } else {
            youTubePlayer.visibility = View.GONE
            thumbnailCardView.visibility = View.VISIBLE

            thumbnailCardView.setOnClickListener {
                setupPlayerVideoWithOfflineCallback()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        youTubePlayer.release()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}