package com.health.dmcare.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.shape.RoundedCornerTreatment
import com.google.android.material.shape.ShapeAppearanceModel
import com.health.dmcare.R
import com.health.dmcare.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    private var _binding: ActivityOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonOnboarding.setOnClickListener {
            val toMainActivity = Intent(this, MainActivity::class.java)
            startActivity(toMainActivity)
            finish()
        }

        setupCardShape()
    }

    private fun setupCardShape() {
        val cornerSizeMessage = resources.getDimension(R.dimen.corner_radius)

        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setTopRightCorner(RoundedCornerTreatment())
            .setTopRightCornerSize(cornerSizeMessage)
            .setTopLeftCorner(RoundedCornerTreatment())
            .setTopLeftCornerSize(cornerSizeMessage)
            .build()

        binding.materialCardViewOnboarding.shapeAppearanceModel = shapeAppearanceModel
        binding.materialCardViewOnboarding.strokeWidth = 0
        binding.materialCardViewOnboarding.elevation = 4f
        binding.materialCardViewOnboarding.setCardBackgroundColor(getColor(R.color.white))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}