package com.health.dmcare.fragment.activities

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.health.dmcare.R
import com.health.dmcare.databinding.FragmentFootExerciseVideoBinding
import com.health.dmcare.util.OnlineCheckerHelper.isOnline
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class FootExerciseVideoFragment : Fragment() {

    private var _binding: FragmentFootExerciseVideoBinding? = null
    private val binding get() = _binding!!
    private lateinit var youTubePlayer: YouTubePlayerView
    private lateinit var thumbnailCardView: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFootExerciseVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        youTubePlayer = binding.pvDetailFootExerciseVideo
        thumbnailCardView = binding.thumbnailOfflineDetailDangerDiabetes

        statusBarSetup()
        setupToolbar()
        setupPlayerVideo()
    }

    @Suppress("DEPRECATION")
    private fun statusBarSetup() {
        requireActivity().window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            statusBarColor = ContextCompat.getColor(requireContext(), R.color.blue)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            }
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

    private fun setupPlayerVideo() {
        if (isOnline(requireContext())) {
            youTubePlayer.visibility = View.VISIBLE
            thumbnailCardView.visibility = View.GONE

            lifecycle.addObserver(youTubePlayer)

            youTubePlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = getString(R.string.foot_exercise_tutorial_video_id)
                    youTubePlayer.cueVideo(videoId, 0f)
                }
            })
        } else {
            youTubePlayer.visibility = View.GONE
            thumbnailCardView.visibility = View.VISIBLE

            thumbnailCardView.setOnClickListener {
                setupPlayerVideo()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}