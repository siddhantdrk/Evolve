package com.app.evolve

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.app.evolve.fragments.WevolvWeVibeAthletesSearchConnectionsFragment
import com.app.evolve.fragments.WevolvWeVibeAthletesSearchNearbyFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class WevolvWeVibeAthletesSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wevolv_we_vibe_athletes_search)
        initAthletesInfo()
    }

    private fun initAthletesInfo() {
        val locationTabs = findViewById<TabLayout>(R.id.athletesTabs)
        val adapter = ViewPagerAdapter(this)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager?.adapter = adapter
        locationTabs!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        TabLayoutMediator(
            locationTabs, viewPager!!
        ) { tab, position ->
            if (position == 0) tab.text = "Connections" else tab.text = "Nearby"
        }.attach()
    }

    class ViewPagerAdapter(fragmentActivity: WevolvWeVibeAthletesSearchActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return if (position == 0) {
                WevolvWeVibeAthletesSearchConnectionsFragment()
            } else {
                WevolvWeVibeAthletesSearchNearbyFragment()
            }
        }
    }
}