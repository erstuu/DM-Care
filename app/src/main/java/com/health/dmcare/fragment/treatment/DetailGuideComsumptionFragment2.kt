package com.health.dmcare.fragment.treatment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.health.dmcare.R
import com.health.dmcare.databinding.FragmentDetailGuideComsumption2Binding
import com.health.dmcare.util.TextFormatterHelper

class DetailGuideComsumptionFragment2 : Fragment() {
    private var _binding: FragmentDetailGuideComsumption2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailGuideComsumption2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        statusBarSetup()
        setupToolbar()
        formatText()
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

    private fun formatText() {
        TextFormatterHelper.makeNumberedList(
            requireContext(),
            binding.bodyOfPertama,
            R.array.body_of_pertama
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}