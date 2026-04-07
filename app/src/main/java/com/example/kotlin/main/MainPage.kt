package com.example.kotlin.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin.R
import com.example.kotlin.databinding.ActivityMainPageBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainPage : AppCompatActivity() {

    private lateinit var binding: ActivityMainPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.mainL)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainL)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.viewPager.adapter = MyPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "First"
                1 -> tab.text = "Second"
            }

        }.attach()
    }
}