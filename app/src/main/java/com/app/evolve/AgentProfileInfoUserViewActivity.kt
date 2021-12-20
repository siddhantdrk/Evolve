package com.app.evolve

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.app.evolve.fragments.AgentProfileInfoUserViewClients1Fragment
import com.app.evolve.fragments.AgentProfileInfoUserViewInfo1Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AgentProfileInfoUserViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent_profile_info_user_view)
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
            if (position == 0) tab.text = "Info" else tab.text = "Clients"
        }.attach()
    }

    class ViewPagerAdapter(fragmentActivity: AgentProfileInfoUserViewActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return if (position == 0) {
                AgentProfileInfoUserViewInfo1Fragment()
            } else {
                AgentProfileInfoUserViewClients1Fragment()
            }
        }
    }
}