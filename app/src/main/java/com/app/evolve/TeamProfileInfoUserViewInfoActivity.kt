package com.app.evolve

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.app.evolve.fragments.TeamProfileInfoUserViewInfo3Fragment
import com.app.evolve.fragments.TeamProfileInfoUserViewInfo4Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TeamProfileInfoUserViewInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_profile_info_user_view_info)
        initProfileInfo()
    }

    private fun initProfileInfo() {
        val profileTabs = findViewById<TabLayout>(R.id.profileTabs)
        val adapter = ViewPagerAdapter(this)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager?.adapter = adapter
        profileTabs!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        TabLayoutMediator(
            profileTabs, viewPager!!
        ) { tab, position ->
            if (position == 0) tab.text = "Info" else tab.text = "Players"
        }.attach()
    }

    class ViewPagerAdapter(fragmentActivity: TeamProfileInfoUserViewInfoActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return if (position == 0) {
                TeamProfileInfoUserViewInfo3Fragment()
            } else {
                TeamProfileInfoUserViewInfo4Fragment()
            }
        }
    }
}