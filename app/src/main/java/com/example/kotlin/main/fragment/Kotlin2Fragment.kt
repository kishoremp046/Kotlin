package com.example.kotlin.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.kotlin.databinding.ActivityKotlin2Binding

class Kotlin2Fragment : Fragment() {
    private var _binding: ActivityKotlin2Binding? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = ActivityKotlin2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle Window Insets (Edge-to-Edge)
        ViewCompat.setOnApplyWindowInsetsListener(binding.kotlin2) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnFind.setOnClickListener {
            val input = binding.etNumber.text.toString()

            if (input.isEmpty()) {
                binding.tvResult.text = " "
                Toast.makeText(requireContext(), "Please enter a number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val number = input.toIntOrNull() ?: 0
            val result = when (number) {
                1 -> "🌞Monday"
                2 -> "🔥 Tuesday"
                3 -> "💧Wednesday"
                4 -> "⚡Thursday"
                5 -> "\uD83C\uDF89Friday"
                6 -> "😎Saturday"
                7 -> "\uD83D\uDE34Sunday"
                else -> showError()
            }

            binding.tvResult.text = result
            binding.tvResult.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun Kotlin2Fragment.showError(): String {
    binding.tvResult.visibility = View.GONE
    Toast.makeText(requireContext(), "Invalid number", Toast.LENGTH_SHORT).show()
    return "No Result found.!!!"
}


