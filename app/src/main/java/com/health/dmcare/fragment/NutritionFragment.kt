package com.health.dmcare.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.health.dmcare.R
import com.health.dmcare.adapter.ExpandStaggeredAdapter
import com.health.dmcare.databinding.FragmentNutritionBinding
import com.health.dmcare.models.DataCardDiabetes
import com.health.dmcare.util.GenerateData

class NutritionFragment : Fragment() {
    private var _binding: FragmentNutritionBinding? = null
    private val binding get() = _binding!!

    private var player: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNutritionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = GenerateData.pengaturanNutrisi()

        setupPlayerVideo()
        setupRecyclerView(items)
        statusBarSetup()
    }

    private fun setupRecyclerView(items: List<DataCardDiabetes>) {
        val adapter = ExpandStaggeredAdapter(items)
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.rvDetailSignAndSymptoms.layoutManager = layoutManager
        binding.rvDetailSignAndSymptoms.adapter = adapter
    }

    private fun setupPlayerVideo() {
        val uri = MediaItem.fromUri("android.resource://${requireContext().packageName}/${R.raw.pengaturan_nutrisi}")

        player = ExoPlayer.Builder(requireContext()).build().apply {
            setMediaItem(uri)
            prepare()
        }

        binding.pvFaktorDiabetesMelitus.player = player
    }

    @Suppress("DEPRECATION")
    private fun statusBarSetup() {
        requireActivity().window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            statusBarColor = ContextCompat.getColor(requireContext(), R.color.background)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    override fun onStop() {
        super.onStop()
        player?.release()
        player = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}