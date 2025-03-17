package com.health.dmcare.adapter.viewpager

import androidx.fragment.app.Fragment
import com.health.dmcare.util.GenerateData

class FootExercisePagerAdapter(fragment: Fragment) : androidx.viewpager2.adapter.FragmentStateAdapter(fragment) {
    private val images = GenerateData.imageResInt()

    private val descriptions = GenerateData.description()

    override fun getItemCount(): Int = images.size

    override fun createFragment(position: Int): Fragment {
        return FootExercisePageFragment.newInstance(images[position], descriptions[position])
    }
}