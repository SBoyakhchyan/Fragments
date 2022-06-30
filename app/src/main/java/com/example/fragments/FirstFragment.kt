package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.Constants.Companion.MAN_CATEGORY_KEY
import com.example.fragments.Constants.Companion.WOMAN_CATEGORY_KEY
import kotlinx.android.synthetic.main.fragment_first.*



class FirstFragment : Fragment() {
    private lateinit var secondFragment: Fragment

    private var stringWoman: String? = null
    private var stringMan: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondFragment = SecondFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val stringWoman: String = getString(R.string.logo_text_woman)
        val stringMan: String = getString(R.string.logo_text_man)
        secondFragment = SecondFragment()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_woman.setOnClickListener {
            addSecondFragmentToActivity()
            newInstance(this.stringWoman.toString(), this.stringMan.toString())
        }
        tv_man.setOnClickListener {
            addSecondFragmentToActivity()
        }
        tv_baby.setOnClickListener {
            addSecondFragmentToActivity()
        }
        tv_travel.setOnClickListener {
            addSecondFragmentToActivity()
        }
        tv_tech.setOnClickListener {
            addSecondFragmentToActivity()
        }
        tv_foodDrink.setOnClickListener {
            addSecondFragmentToActivity()
        }

    }

    private fun addSecondFragmentToActivity() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, secondFragment, "first")?.addToBackStack("first")
            ?.commit()
    }

    companion object{
        @JvmStatic
        fun newInstance(stringWoman: String, stringMan: String) {

            FirstFragment().apply {

                val bundle = Bundle()
                arguments = bundle.apply {
                    putString(WOMAN_CATEGORY_KEY, context?.getString(R.string.logo_text_man))
                    putString(MAN_CATEGORY_KEY, context?.getString(R.string.logo_text_man))
                }
            }
        }
    }
}