package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.fragments.Constants.Companion.USERNAME_SET_KEY

class InstagramWelcomePageFragment : Fragment() {
    private lateinit var welcomeDear: AppCompatTextView

    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString(USERNAME_SET_KEY).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instagram_welcome_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initToast(getString(R.string.toast_text))
        setText(username)
    }


    companion object {
        @JvmStatic
        fun newInstance(username: String) =
            InstagramWelcomePageFragment().apply {
                arguments = Bundle().apply {
                    putString(USERNAME_SET_KEY, username)
                }
            }
    }

    private fun initView() {
        welcomeDear = requireView().findViewById(R.id.welcome_dear)
    }

    private fun initToast(message: String) {
        Toast.makeText(context, String.format(message, username), Toast.LENGTH_SHORT).show()
    }

    private fun setText(username: String) {
        welcomeDear.setText(String.format(getString(R.string.welcome_dear, username)))
    }
}