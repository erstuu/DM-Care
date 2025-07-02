package com.health.dmcare.fragment.activities

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.health.dmcare.R
import com.health.dmcare.databinding.FragmentFootExerciseBinding

class FootExerciseFragment : Fragment() {

    private var _binding: FragmentFootExerciseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFootExerciseBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAction()
        statusBarSetup()
        setupToolbar()
    }

    private fun setupAction() {
        binding.footExerciseCard.setOnClickListener {
            findNavController().navigate(R.id.action_footExerciseFragment_to_detailFootExerciseFragment)
        }
        binding.videoFootExerciseCard.setOnClickListener {
            findNavController().navigate(R.id.action_footExerciseFragment_to_footExerciseVideoFragment)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @Suppress("DEPRECATION")
    private fun statusBarSetup() {
        requireActivity().window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            statusBarColor = ContextCompat.getColor(requireContext(), R.color.background)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}