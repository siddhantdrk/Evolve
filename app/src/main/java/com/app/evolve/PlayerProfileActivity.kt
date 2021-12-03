package com.app.evolve

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.app.evolve.fragments.MyCode
import com.app.evolve.fragments.ScanACodeFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class PlayerProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.player_profile)
        initProfileInfo()
    }

    private fun initProfileInfo() {
        val profileTabs = findViewById<TabLayout>(R.id.profileTabs)
        val adapter = ViewPagerAdapter(this)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager?.adapter = adapter
        profileTabs!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (tab.position == 0) {
                    profileTabs.setTabTextColors(
                        ContextCompat.getColor(this@PlayerProfileActivity, R.color.app_background),
                        ContextCompat.getColor(this@PlayerProfileActivity, R.color.text_color)
                    )

                } else {
                    profileTabs.setTabTextColors(
                        ContextCompat.getColor(this@PlayerProfileActivity, R.color.tab_unselected),
                        ContextCompat.getColor(this@PlayerProfileActivity, R.color.text_color)
                    )
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        TabLayoutMediator(
            profileTabs, viewPager!!
        ) { tab, position ->
            if (position == 0) tab.text = "Info" else tab.text = "Arena"
        }.attach()
    }

    class ViewPagerAdapter(fragmentActivity: PlayerProfileActivity) :
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
}