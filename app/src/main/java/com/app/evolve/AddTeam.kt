package com.app.evolve

import android.hardware.display.DisplayManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import androidx.viewpager2.widget.ViewPager2
import com.app.evolve.adapter.viewpager.ViewPagerAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.card.MaterialCardView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator


class AddTeam : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_team)

        findViewById<MaterialCardView>(R.id.buttonAddTeam).setOnClickListener {
            showBottomSheetDialog()
        }
    }

    private fun showBottomSheetDialog() {
        val metrics = DisplayMetrics()
        val displayManager = getSystemService<DisplayManager>()!!
        val defaultDisplay = displayManager.getDisplay(Display.DEFAULT_DISPLAY)
        defaultDisplay.getRealMetrics(metrics)
        val height = metrics.heightPixels
        val bottomSheetDialog = BottomSheetDialog(this, R.style.SheetDialog)
        bottomSheetDialog.setContentView(R.layout.qr_code)
        val constrainLayout = bottomSheetDialog.findViewById<ConstraintLayout>(R.id.constrainLayout)
        initQRCode(bottomSheetDialog, constrainLayout)
        constrainLayout!!.minHeight = height
        bottomSheetDialog.behavior.isFitToContents = false
        bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetDialog.show()

    }

    private fun initQRCode(
        bottomSheetDialog: BottomSheetDialog,
        constrainLayout: ConstraintLayout?
    ) {
        val qrTabs = bottomSheetDialog.findViewById<TabLayout>(R.id.qrTabs)
        val adapter = ViewPagerAdapter(this)
        val viewPager = bottomSheetDialog.findViewById<ViewPager2>(R.id.viewPager)
        viewPager?.adapter = adapter
        qrTabs!!.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                /*if (tab.position == 0) {
                    constrainLayout!!.setBackgroundColor(
                        ContextCompat.getColor(
                            this@AddTeam,
                            R.color.black_alpha_70
                        )
                    )
                } else {
                    constrainLayout!!.setBackgroundColor(
                        ContextCompat.getColor(
                            this@AddTeam,
                            R.color.app_background
                        )
                    )
                }*/
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        TabLayoutMediator(
            qrTabs!!, viewPager!!
        ) { tab, position ->
            if (position == 0) tab.text = "Scan A Code " else tab.text = "My Code"
        }.attach()
    }
}