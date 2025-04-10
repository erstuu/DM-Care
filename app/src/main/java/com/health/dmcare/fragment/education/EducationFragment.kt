package com.health.dmcare.fragment.education

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.health.dmcare.R
import com.health.dmcare.adapter.LinierAdapter
import com.health.dmcare.databinding.FragmentEducationBinding
import com.health.dmcare.models.DataCardDiabetes
import com.health.dmcare.util.GenerateData
import com.health.dmcare.util.ViewModelFactory

class EducationFragment : Fragment() {
    private var _binding: FragmentEducationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)[EducationViewModel::class.java]
        viewModel.greeting.observe(viewLifecycleOwner) { greeting ->
            binding.selamatPagi.text = greeting
        }

        val items = GenerateData.tandaGejalaDiabetes()

        setupDialog()
        setupRecyclerView(items)
        setupAction()
        statusBarSetup()
    }

    private fun setupDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.title_renungan))
            .setMessage(getString(R.string.renungan_education_page))
            .setPositiveButton(getString(R.string.oke)) { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
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

    private fun setupRecyclerView(items: List<DataCardDiabetes>) {
        val adapter = LinierAdapter(items)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTandaDanGejala.layoutManager = layoutManager
        binding.rvTandaDanGejala.adapter = adapter
    }

    private fun setupAction() {
        binding.buttonDefinisiDiabetes.setOnClickListener {
            findNavController().navigate(R.id.action_educationFragment_to_detailDescriptionDiabetesFragment)
        }

        binding.lihatSelengkapnya.setOnClickListener {
            findNavController().navigate(R.id.action_educationFragment_to_detailSignAndSymptomsFragment)
        }

        binding.bahayaDiabetesMelitusCard.setOnClickListener {
            findNavController().navigate(R.id.action_educationFragment_to_detailDangerDiabetesFragment)
        }

        binding.faktorDiabetesMelitusCard.setOnClickListener {
            findNavController().navigate(R.id.action_educationFragment_to_detailFactorDiabetesFragment)
        }

        binding.cvTentangKami.setOnClickListener{
            findNavController().navigate(R.id.action_educationFragment_to_aboutFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}