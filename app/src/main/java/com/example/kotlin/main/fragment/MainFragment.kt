package com.example.kotlin.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.kotlin.R
import com.example.kotlin.databinding.ActivityMainBinding
import kotlin.random.Random

class MainFragment : Fragment() {

    private val name = "Kishore"
    private val name1 = "Sakaleshpura"

    // View Binding logic for Fragments
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle Window Insets (Edge-to-Edge)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Show Alert Dialog - Use requireContext()
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Kotlin")
            .setIcon(R.drawable.open)
            .setMessage("Welcome to Our App")
            .setCancelable(false)
            .setPositiveButton("START") { dialog, _ ->
                dialog.dismiss()
            }
        val alertDialog = builder.create()
        alertDialog.show()

        // Create click listener
        val clickListener = View.OnClickListener { v ->
            when (v.id) {
                R.id.name1_Btn -> {
                    binding.main.setBackgroundColor(resources.getColor(R.color.green, null))
                }
                R.id.name2_Btn -> {
                    binding.main.setBackgroundColor(resources.getColor(R.color.red, null))
                }
                R.id.btn -> {
                    val number1 = Random.Default.nextInt(6)
                    val number2 = Random.Default.nextInt(6)
                    binding.value1.text = number1.toString()
                    binding.value2.text = number2.toString()

                    if (number1 == number2) {
                        binding.result.text = "You Won :)"
                        binding.main.setBackgroundColor(resources.getColor(R.color.green, null))
                        binding.result.setTextColor(resources.getColor(R.color.Gree, null))
                    } else {
                        binding.result.text = "You Lost :("
                        binding.result.setTextColor(resources.getColor(R.color.REE, null))
                        binding.main.setBackgroundColor(resources.getColor(R.color.red, null))
                    }
                }

            }
        }

        // Set click listeners
        binding.name1Btn.setOnClickListener(clickListener)
        binding.name2Btn.setOnClickListener(clickListener)
        binding.btn.setOnClickListener(clickListener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}