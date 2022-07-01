package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_woman.setOnClickListener {
            addSecondFragmentToActivity(Constants.WOMAN_CATEGORY_KEY)
        }
        tv_man.setOnClickListener {
            addSecondFragmentToActivity(Constants.MAN_CATEGORY_KEY)
        }
        tv_baby.setOnClickListener {
            addSecondFragmentToActivity(Constants.BABY_CATEGORY_KEY)
        }
        tv_travel.setOnClickListener {
            addSecondFragmentToActivity(Constants.TRAVEL_CATEGORY_KEY)
        }
        tv_tech.setOnClickListener {
            addSecondFragmentToActivity(Constants.TECH_CATEGORY_KEY)
        }
        tv_foodDrink.setOnClickListener {
            addSecondFragmentToActivity(Constants.FOOD_AND_DRINK_CATEGORY_KEY)
        }

    }

    private fun addSecondFragmentToActivity(category: String) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.container, SecondFragment.newInstance(category), "first")
            ?.addToBackStack("first")
            ?.commit()
    }
}