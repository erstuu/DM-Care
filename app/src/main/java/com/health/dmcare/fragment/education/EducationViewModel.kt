package com.health.dmcare.fragment.education

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Calendar

class EducationViewModel : ViewModel() {
    private val _greeting = MutableLiveData<String>()
    val greeting: LiveData<String> = _greeting

    private val handler = Handler(Looper.getMainLooper())
    private val updateGreetingTask = object : Runnable {
        override fun run() {
            updateGreeting()
            handler.postDelayed(this, 60 * 1000)
        }
    }

    init {
        updateGreeting()
        startTimer()
    }

    private fun startTimer() {
        handler.post(updateGreetingTask)
    }

    private fun updateGreeting() {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val greetingText = when (hour) {
            in 1..10 -> "Selamat Pagi"
            in 11..14 -> "Selamat Siang"
            in 15..17 -> "Selamat Sore"
            else -> "Selamat Malam"
        }
        _greeting.postValue(greetingText)
    }

    override fun onCleared() {
        super.onCleared()
        handler.removeCallbacks(updateGreetingTask)
    }
}