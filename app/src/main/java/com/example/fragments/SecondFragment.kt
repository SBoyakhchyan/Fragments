package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments.Constants.Companion.MAN_CATEGORY_KEY
import com.example.fragments.Constants.Companion.WOMAN_CATEGORY_KEY
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {
    private lateinit var firstFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_second, container, false)
        firstFragment = FirstFragment()
        arguments = Bundle()

        arguments?.let {
            tv_company?.text = it.getString(WOMAN_CATEGORY_KEY)
            tv_motivation?.text = it.getString(MAN_CATEGORY_KEY)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_back.setOnClickListener {
            backToFirstFragment()
        }
    }

    private fun backToFirstFragment() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, firstFragment,"second")?.addToBackStack("second")
            ?.commit()
    }
}