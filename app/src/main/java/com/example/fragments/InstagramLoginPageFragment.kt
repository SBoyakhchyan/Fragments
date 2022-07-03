package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main_exam.*
import kotlinx.android.synthetic.main.fragment_instagram_login_page.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class InstagramLoginPageFragment : Fragment() {
    private lateinit var appUsername: AppCompatEditText
    private lateinit var appPassword: AppCompatEditText
    private lateinit var instagramWelcomePageFragment: InstagramWelcomePageFragment
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var loginTemp: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_instagram_login_page, container_exam, false)
        instagramWelcomePageFragment = InstagramWelcomePageFragment()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_login.setOnClickListener {
            fieldsCheck()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InstagramLoginPageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun addWelcomePageToActivity() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container_exam, InstagramWelcomePageFragment.newInstance(loginTemp), "first")
            ?.addToBackStack("first")
            ?.commit()
    }

    private fun fieldsCheck() {
        appUsername = requireView().findViewById(R.id.et_username_field)
        appPassword = requireView().findViewById(R.id.et_password_field)
        loginTemp = appUsername.text.toString()
        val passwordTemp = appPassword.text.toString()
        loginTemp.trim()
        passwordTemp.trim()
        if (loginTemp.isEmpty() || loginTemp.length < 7 || !loginTemp[0].isUpperCase()) {
            Snackbar.make(
                requireActivity().findViewById(R.id.root_exam),
                "Username is not valid",
                Snackbar.LENGTH_SHORT
            ).show()
        } else if (passwordTemp.isEmpty() || passwordTemp.length < 7 || passwordTemp[0].isDigit()) {
            Snackbar.make(
                requireActivity().findViewById(R.id.root_exam),
                "Password is not valid",
                Snackbar.LENGTH_SHORT
            ).show()
        } else {
            addWelcomePageToActivity()
        }
    }
}