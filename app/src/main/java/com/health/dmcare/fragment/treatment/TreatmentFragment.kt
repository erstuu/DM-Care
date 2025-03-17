package com.health.dmcare.fragment.treatment

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
import com.health.dmcare.R
import com.health.dmcare.databinding.FragmentTreatmentBinding

class TreatmentFragment : Fragment() {
    private var _binding: FragmentTreatmentBinding? = null
    private val binding get() = _binding!!

    private var player: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTreatmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAction()
        setupPlayerVideo()
        statusBarSetup()
    }

    private fun setupPlayerVideo() {
        val uri = MediaItem.fromUri("android.resource://${requireContext().packageName}/${R.raw.panduan_konsumsi}")

        player = ExoPlayer.Builder(requireContext()).build().apply {
            setMediaItem(uri)
            prepare()
        }

        binding.pvPanduanKonsumsi.player = player
    }

    private fun setupAction() {
        binding.panduanKonsumsiCard.setOnClickListener {
            findNavController().navigate(R.id.action_treatmentFragment2_to_detailGuideComsumptionFragment)
        }
        binding.panduanKonsumsi2Card.setOnClickListener {
            findNavController().navigate(R.id.action_treatmentFragment2_to_detailGuideComsumptionFragment2)
        }
        binding.doaCard.setOnClickListener {
            findNavController().navigate(R.id.action_treatmentFragment2_to_detailPrayFragment)
        }
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