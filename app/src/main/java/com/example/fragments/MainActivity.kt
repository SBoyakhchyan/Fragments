package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.DrawableCompat

class MainActivity : AppCompatActivity() {
    private lateinit var firstFragment: FirstFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstFragment = FirstFragment()
        addFragmentToActivity()
        supportActionBar?.title = "Categories"
    }

    private fun addFragmentToActivity() {
        supportFragmentManager.beginTransaction().add(R.id.container, firstFragment).commit()
    }
}