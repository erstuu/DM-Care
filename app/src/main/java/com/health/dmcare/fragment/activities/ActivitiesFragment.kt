package com.health.dmcare.fragment.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.health.dmcare.R
import com.health.dmcare.databinding.FragmentActivitiesBinding

class ActivitiesFragment : Fragment() {
    private var _binding: FragmentActivitiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActivitiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAction()
        statusBarSetup()
    }

    private fun setupAction() {
        binding.aktivitasFisikCard.setOnClickListener {
            findNavController().navigate(R.id.action_activitiesFragment_to_detailAktivitasFisikFragment)
        }
        binding.perawatanKakiCard.setOnClickListener {
            findNavController().navigate(R.id.action_activitiesFragment_to_detailPerawatanKakiFragment)
        }
        binding.footExerciseCard.setOnClickListener {
            findNavController().navigate(R.id.action_activitiesFragment_to_detailFootExerciseFragment)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}