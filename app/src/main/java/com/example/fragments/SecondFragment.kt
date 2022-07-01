package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.fragments.Constants.Companion.BABY_CATEGORY_KEY
import com.example.fragments.Constants.Companion.BABY_IMAGE_URL
import com.example.fragments.Constants.Companion.CATEGORY
import com.example.fragments.Constants.Companion.FOOD_AND_DRINK_CATEGORY_KEY
import com.example.fragments.Constants.Companion.FOOD_DRINK_IMAGE_URL
import com.example.fragments.Constants.Companion.MAN_CATEGORY_KEY
import com.example.fragments.Constants.Companion.MAN_IMAGE_URL
import com.example.fragments.Constants.Companion.TECH_CATEGORY_KEY
import com.example.fragments.Constants.Companion.TECH_IMAGE_URL
import com.example.fragments.Constants.Companion.TRAVEL_CATEGORY_KEY
import com.example.fragments.Constants.Companion.TRAVEL_IMAGE_URL
import com.example.fragments.Constants.Companion.WOMAN_CATEGORY_KEY
import com.example.fragments.Constants.Companion.WOMAN_IMAGE_URL
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {
    private var list = mutableListOf<Model>()
    private lateinit var firstFragment: Fragment
    private var category: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            category = it.getString(CATEGORY).toString()
        }
        initList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        firstFragment = FirstFragment()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setView()
        btn_back.setOnClickListener {
            backToFirstFragment()
        }
    }

    private fun initList() {
        list.add(Model(WOMAN_CATEGORY_KEY,"Woman","Woman are funny", WOMAN_IMAGE_URL,"Get Dressed all the time"))
        list.add(Model(MAN_CATEGORY_KEY,"Man","Men are strong", MAN_IMAGE_URL,"Keep Go on"))
        list.add(Model(BABY_CATEGORY_KEY,"Baby","Babies are cute", BABY_IMAGE_URL,"Be clever always"))
        list.add(Model(TRAVEL_CATEGORY_KEY,"Travel","Travel all over the world", TRAVEL_IMAGE_URL,"Be in touch everywhere"))
        list.add(Model(TECH_CATEGORY_KEY,"Tech","Smart things for you", TECH_IMAGE_URL,"Be smarter, get faster"))
        list.add(Model(FOOD_AND_DRINK_CATEGORY_KEY,"Food and Drink","Tasty food and cool drinks", FOOD_DRINK_IMAGE_URL,"Take with you"))

    }

    private fun setView() {
        list.forEach {
            if (category == it.category) {
                Glide.with(requireContext())
                    .load(it.imageUrl)
                    .override(480,480)
                    .centerCrop()
                    .into(logo_image)
                //Glide.with(requireContext()).load(it.imageUrl).into(logo_image);
                tv_company.text = it.title
                tv_slogan.text = it.moto
                tv_motivation.text = it.description
            }
        }

    }

    private fun backToFirstFragment() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, firstFragment)?.commit()
    }

    companion object {

        @JvmStatic
        fun newInstance(category: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(CATEGORY, category)
                }
            }
    }
}