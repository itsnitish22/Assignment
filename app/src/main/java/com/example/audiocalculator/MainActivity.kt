package com.example.audiocalculator

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.audiocalculator.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private var textToSpeech: TextToSpeech? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        speak("What are two twos?")

        binding.check.setOnClickListener {
            if (binding.inputans.text.isEmpty()) {
                Toast.makeText(this, "Enter answer first", Toast.LENGTH_SHORT).show()
            } else {
                if (binding.inputans.text.toString() == "4") {
                    speak("Correct answer")
                } else {
                    speak("Wrong answer")
                }
            }
        }
    }

    private fun speak(s: String) {
        textToSpeech = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it == TextToSpeech.SUCCESS) {
                textToSpeech?.language ?: Locale.US
                textToSpeech?.setSpeechRate(1.0f)
                textToSpeech?.speak(s, TextToSpeech.QUEUE_ADD, null)
            }
        })
    }

}