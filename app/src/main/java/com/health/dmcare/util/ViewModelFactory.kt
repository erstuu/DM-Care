package com.health.dmcare.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.health.dmcare.fragment.education.EducationViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EducationViewModel::class.java)) {
            return EducationViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}