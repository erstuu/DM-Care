package com.health.dmcare.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.health.dmcare.R
import com.health.dmcare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        val bottomNavigation = binding.bottomNavigation
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavigation.setupWithNavController(navController)

        // Hide bottom navigation bar when navigating to certain fragments
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.detailDescriptionDiabetesFragment,
                R.id.detailSignAndSymptomsFragment,
                R.id.detailDangerDiabetesFragment,
                R.id.detailFactorDiabetesFragment,
                R.id.detailPerawatanKakiFragment,
                R.id.detailAktivitasFisikFragment,
                R.id.aboutFragment,
                R.id.footExerciseFragment,
                R.id.footExerciseVideoFragment,
                R.id.detailFootExerciseFragment -> {
                    bottomNavigation.visibility = View.GONE
                }
                else -> {
                    bottomNavigation.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}