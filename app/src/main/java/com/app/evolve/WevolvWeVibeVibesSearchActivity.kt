package com.app.evolve

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.app.evolve.fragments.WevolvWeVibeLocationsSearchFavouritesFragment
import com.app.evolve.fragments.WevolvWeVibeVibesSearchNearbyFragment
import com.app.evolve.fragments.WevolvWeVibeVibesSearchRecommendedFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class WevolvWeVibeVibesSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wevolv_we_vibe_vibes_search)
        initVibesInfo()
    }

    private fun initVibesInfo() {
        val locationTabs = findViewById<TabLayout>(R.id.locationTabs)
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
            if (position == 0) tab.text = "Nearby" else if (position == 1) tab.text =
                "Recommended" else tab.text = "Favorites"
        }.attach()
    }

    class ViewPagerAdapter(fragmentActivity: WevolvWeVibeVibesSearchActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            if (position == 0) {
                return WevolvWeVibeVibesSearchNearbyFragment()
            } else if (position == 1) {
                return WevolvWeVibeVibesSearchRecommendedFragment()
            } else {
                return WevolvWeVibeLocationsSearchFavouritesFragment()
            }
        }
    }
}