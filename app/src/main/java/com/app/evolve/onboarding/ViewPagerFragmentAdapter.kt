package com.app.evolve.onboarding

import androidx.fragment.app.Fragment
import com.app.evolve.onboarding.OnBoardingFragment.Companion.newInstance
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList

class ViewPagerFragmentAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val arrayList = ArrayList<Fragment>()
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return newInstance()
    }
}