package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivityExam : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_exam)
        addFragmentToActivity()
        val actionBar = supportActionBar
        actionBar?.hide()
    }

    private fun addFragmentToActivity() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container_exam, InstagramLoginPageFragment()).commit()
    }
}