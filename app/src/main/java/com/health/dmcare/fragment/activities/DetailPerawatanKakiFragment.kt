package com.health.dmcare.fragment.activities

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
import com.health.dmcare.adapter.ExpandStaggeredAdapter
import com.health.dmcare.databinding.FragmentDetailPerawatanKakiBinding
import com.health.dmcare.models.DataCardDiabetes
import com.health.dmcare.util.GenerateData

class DetailPerawatanKakiFragment : Fragment() {
    private var _binding: FragmentDetailPerawatanKakiBinding? = null
    private val binding get() = _binding!!

    private var player: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailPerawatanKakiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusBarSetup()
        setupToolbar()

        val items = GenerateData.perawatanKaki()
        setupRecyclerView(items)
        setupPlayerVideo()
    }

    private fun setupRecyclerView(items: List<DataCardDiabetes>) {
        val adapter = ExpandStaggeredAdapter(items)
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.rvPerawatanKaki.layoutManager = layoutManager
        binding.rvPerawatanKaki.adapter = adapter
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
        val uri = MediaItem.fromUri("android.resource://${requireContext().packageName}/${R.raw.perawatan_kaki}")

        player = ExoPlayer.Builder(requireContext()).build().apply {
            setMediaItem(uri)
            prepare()
        }

        binding.pvPerawatanKaki.player = player
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