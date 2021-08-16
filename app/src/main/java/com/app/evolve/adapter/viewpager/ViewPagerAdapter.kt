package com.app.evolve.adapter.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.evolve.fragments.MyCode
import com.app.evolve.fragments.ScanACodeFragment
import com.app.evolve.onboarding.OnBoardingFragment
import java.util.ArrayList

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val arrayList = ArrayList<Fragment>()
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            ScanACodeFragment()
        } else {
            MyCode()
        }

    }
}