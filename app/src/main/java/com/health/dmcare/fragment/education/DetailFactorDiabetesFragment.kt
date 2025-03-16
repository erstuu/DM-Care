package com.health.dmcare.fragment.education

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.health.dmcare.R
import com.health.dmcare.adapter.StaggeredAdapter
import com.health.dmcare.databinding.FragmentDetailFactorDiabetesBinding
import com.health.dmcare.models.TandaGejalaDiabetes
import com.health.dmcare.util.GenerateData

class DetailFactorDiabetesFragment : Fragment() {
    private var _binding: FragmentDetailFactorDiabetesBinding? = null
    private val binding get() = _binding!!

    private var player: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailFactorDiabetesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items = GenerateData.faktorDiabetesMelitus()

        statusBarSetup()
        setupToolbar()
        setupPlayerVideo()
        setupRecyclerView(items)
    }

    private fun setupRecyclerView(items: List<TandaGejalaDiabetes>) {
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

    private fun setupPlayerVideo() {
        val uri = MediaItem.fromUri("android.resource://${requireContext().packageName}/${R.raw.faktor_resiko}")

        player = ExoPlayer.Builder(requireContext()).build().apply {
            setMediaItem(uri)
            prepare()
        }

        binding.pvFaktorDiabetesMelitus.player = player
    }

    override fun onStop() {
        super.onStop()
        player?.release()
        player = null
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}