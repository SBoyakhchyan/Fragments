package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import com.example.fragments.Constants.Companion.BACKTO_SIGNIN_PAGE_TAG
import com.google.android.material.snackbar.Snackbar

class InstagramLoginPageFragment : Fragment() {
    private lateinit var appUsername: AppCompatEditText
    private lateinit var appPassword: AppCompatEditText
    private lateinit var loginTemp: String
    private lateinit var passwordTemp: String
    private lateinit var btnLogin: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_instagram_login_page, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        btnLogin.setOnClickListener {
            fieldsCheck()
        }
    }

    private fun addWelcomePageToActivity() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_exam,
                InstagramWelcomePageFragment.newInstance(loginTemp),
                BACKTO_SIGNIN_PAGE_TAG
            )
            .addToBackStack(BACKTO_SIGNIN_PAGE_TAG)
            .commit()
    }

    private fun fieldsCheck() {
        loginTemp = appUsername.text.toString().trim()
        passwordTemp = appPassword.text.toString().trim()
        if (loginTemp.isEmpty() || loginTemp.length < 7 || !loginTemp[0].isUpperCase()) {
            snackBar(getString(R.string.username_is_not_valid))
        } else if (passwordTemp.isEmpty() || passwordTemp.length < 7 || passwordTemp[0].isDigit()) {
            snackBar(getString(R.string.password_is_not_valid))
        } else {
            addWelcomePageToActivity()
            clearInputData()
        }
    }

    private fun initView() {
        appUsername = requireView().findViewById(R.id.etUsername)
        appPassword = requireView().findViewById(R.id.etPassword)
        btnLogin = requireView().findViewById(R.id.btn_login)
    }

    private fun snackBar(message: String) {
        Snackbar.make(
            requireActivity().findViewById(R.id.root_exam),
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private fun clearInputData(){
        appUsername.setText("")
        appPassword.setText("")
    }
}