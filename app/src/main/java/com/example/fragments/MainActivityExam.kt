package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivityExam : AppCompatActivity() {
    //TODO no need, see below
    private lateinit var instagramLoginPageFragment: InstagramLoginPageFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_exam)
        instagramLoginPageFragment = InstagramLoginPageFragment()
        addFragmentToActivity()
        val actionBar = supportActionBar
        actionBar?.hide()
    }
//TODO just supportFragmentManager.beginTransaction().add(R.id.container_exam, InstagramLoginPageFragment()).commit()
    private fun addFragmentToActivity() {
        supportFragmentManager.beginTransaction().add(R.id.container_exam, instagramLoginPageFragment).commit()
    }
}