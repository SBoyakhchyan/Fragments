package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragments.Constants.Companion.USERNAME_SET_KEY
import kotlinx.android.synthetic.main.fragment_instagram_welcome_page.*

class InstagramWelcomePageFragment : Fragment() {

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(USERNAME_SET_KEY)
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
            Toast.makeText(context, "You have been successfully longed in  $param1", Toast.LENGTH_SHORT).show()

//  TODO use String.format
        welcome_dear.text = welcome_dear.text.toString() +" " + param1
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
}