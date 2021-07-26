package com.app.evolve.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.evolve.R

class OnBoardingFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.onbording_items,
            container, false
        ) as ViewGroup
    }

    companion object {
        @JvmStatic
        fun newInstance(): OnBoardingFragment {
            return OnBoardingFragment()
        }
    }
}