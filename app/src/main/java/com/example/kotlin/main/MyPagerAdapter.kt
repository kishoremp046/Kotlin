package com.example.kotlin.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin.main.fragment.Kotlin2Fragment
import com.example.kotlin.main.fragment.MainFragment

class MyPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {


    override fun createFragment(position: Int): Fragment {

        return when(position){
            0-> MainFragment()
            1-> Kotlin2Fragment()
            else -> MainFragment()
        }
    }

    override fun getItemCount(): Int =2
}