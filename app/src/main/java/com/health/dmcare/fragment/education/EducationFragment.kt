package com.health.dmcare.fragment.education

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.health.dmcare.adapter.LinierAdapter
import com.health.dmcare.databinding.FragmentEducationBinding
import com.health.dmcare.models.TandaGejalaDiabetes
import com.health.dmcare.util.GenerateData

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

        val items = GenerateData.tandaGejalaDiabetes()

        setupRecyclerView(items)
        setupAction()
    }

    private fun setupRecyclerView(items: List<TandaGejalaDiabetes>) {
        val adapter = LinierAdapter(items)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTandaDanGejala.layoutManager = layoutManager
        binding.rvTandaDanGejala.adapter = adapter
    }

    private fun setupAction() {
        binding.buttonDefinisiDiabetes.setOnClickListener {
            val toDetailDescriptionDiabetesFragment = EducationFragmentDirections.actionEducationFragmentToDetailDescriptionDiabetesFragment()
            findNavController().navigate(toDetailDescriptionDiabetesFragment)
        }

        binding.lihatSelengkapnya.setOnClickListener {
            val toDetailDescriptionDiabetesFragment = EducationFragmentDirections.actionEducationFragmentToDetailSignAndSymptomsFragment()
            findNavController().navigate(toDetailDescriptionDiabetesFragment)
        }

        binding.bahayaDiabetesMelitusCard.setOnClickListener {
            val toDetailDescriptionDiabetesFragment = EducationFragmentDirections.actionEducationFragmentToDetailDangerDiabetesFragment()
            findNavController().navigate(toDetailDescriptionDiabetesFragment)
        }

        binding.faktorDiabetesMelitusCard.setOnClickListener {
            val toDetailDescriptionDiabetesFragment = EducationFragmentDirections.actionEducationFragmentToDetailFactorDiabetesFragment()
            findNavController().navigate(toDetailDescriptionDiabetesFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}