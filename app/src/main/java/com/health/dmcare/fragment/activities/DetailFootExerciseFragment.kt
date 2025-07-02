package com.health.dmcare.fragment.activities

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.health.dmcare.R
import com.health.dmcare.adapter.viewpager.FootExercisePagerAdapter
import com.health.dmcare.databinding.FragmentDetailFootExerciseBinding

class DetailFootExerciseFragment : Fragment() {
    private var _binding: FragmentDetailFootExerciseBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailFootExerciseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        statusBarSetup()
        setupToolbar()
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = FootExercisePagerAdapter(this)
        binding.vpFootExercise.adapter = adapter

        viewPager = binding.vpFootExercise
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position < adapter.itemCount - 1) {
                    binding.vpButtonNext.text = requireContext().getString(R.string.selanjutnya)
                    binding.vpButtonNext.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.button_background_dark_blue))
                } else {
                    binding.vpButtonNext.text = getString(R.string.selesai)
                    binding.vpButtonNext.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.button_background_red))
                }
            }
        })

        binding.vpButtonNext.setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem < adapter.itemCount - 1) {
                viewPager.currentItem = currentItem + 1
            } else {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }


    @Suppress("DEPRECATION")
    private fun statusBarSetup() {
        requireActivity().window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            statusBarColor = ContextCompat.getColor(requireContext(), R.color.blue)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            }
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
