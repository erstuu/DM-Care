package com.health.dmcare.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.health.dmcare.R
import com.health.dmcare.databinding.FragmentMonitoringBinding
import com.health.dmcare.util.TextFormatterHelper

class MonitoringFragment : Fragment() {
    private var _binding: FragmentMonitoringBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMonitoringBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusBarSetup()

        formatText()
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

    private fun formatText() {
        TextFormatterHelper.makeNumberedList(
            requireContext(),
            binding.bodyOfTujuanPemeriksaanGlukosaDarah,
            R.array.tujuan_pemeriksaan_gula_darah
        )

        TextFormatterHelper.makeNumberedList(
            requireContext(),
            binding.bodyOfWaktuPelaksanaan,
            R.array.waktu_pelaksanaan
        )

        TextFormatterHelper.makeNumberedList(
            requireContext(),
            binding.bodyOfPerhatikanJika,
            R.array.perhatikan_jika
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}