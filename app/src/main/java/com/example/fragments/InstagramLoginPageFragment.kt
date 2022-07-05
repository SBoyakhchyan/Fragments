package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import com.example.fragments.Constants.Companion.BACKTO_SIGNIN_PAGE_TAG
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main_exam.*
import kotlinx.android.synthetic.main.fragment_instagram_login_page.*

class InstagramLoginPageFragment : Fragment() {
    private lateinit var appUsername: AppCompatEditText
    private lateinit var appPassword: AppCompatEditText
    private lateinit var loginTemp: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_instagram_login_page, container_exam, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_login.setOnClickListener {
            fieldsCheck()
        }

    }

    private fun addWelcomePageToActivity() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(
                R.id.container_exam,
                InstagramWelcomePageFragment.newInstance(loginTemp),
                BACKTO_SIGNIN_PAGE_TAG
            )
            ?.addToBackStack(BACKTO_SIGNIN_PAGE_TAG)
            ?.commit()
        appUsername.setText("")
        appPassword.setText("")
    }

    private fun fieldsCheck() {
        initView()
        loginTemp = appUsername.text.toString()
        val passwordTemp = appPassword.text.toString()
        loginTemp.trim()
        passwordTemp.trim()
        if (loginTemp.isEmpty() || loginTemp.length < 7 || !loginTemp[0].isUpperCase()) {
            Snackbar.make(
                requireActivity().findViewById(R.id.root_exam),
                R.string.username_is_not_valid,
                Snackbar.LENGTH_SHORT
            ).show()
        } else if (passwordTemp.isEmpty() || passwordTemp.length < 7 || passwordTemp[0].isDigit()) {
            Snackbar.make(
                requireActivity().findViewById(R.id.root_exam),
                R.string.password_is_not_valid,
                Snackbar.LENGTH_SHORT
            ).show()
        } else {
            addWelcomePageToActivity()
        }
    }

    private fun initView() {
        appUsername = requireView().findViewById(R.id.et_username_field)
        appPassword = requireView().findViewById(R.id.et_password_field)
    }
}