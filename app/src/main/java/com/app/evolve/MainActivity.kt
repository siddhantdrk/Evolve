package com.app.evolve

import android.hardware.display.DisplayManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.app.evolve.adapter.viewpager.ViewPagerAdapter
import com.app.evolve.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        showBottomSheetDialog()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
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
        val qrParent = bottomSheetDialog.findViewById<LinearLayout>(R.id.qrParent)
        val tabFrame = bottomSheetDialog.findViewById<FrameLayout>(R.id.tabFrame)
        initQRCode(bottomSheetDialog, qrParent, tabFrame)
        constrainLayout!!.minHeight = height
        bottomSheetDialog.behavior.isFitToContents = false
        bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetDialog.show()
    }

    private fun initQRCode(
        bottomSheetDialog: BottomSheetDialog,
        qrParent: LinearLayout?,
        tabFrame: FrameLayout?
    ) {
        val qrTabs = bottomSheetDialog.findViewById<TabLayout>(R.id.qrTabs)
        val adapter = ViewPagerAdapter(this)
        val viewPager = bottomSheetDialog.findViewById<ViewPager2>(R.id.viewPager)
        viewPager?.adapter = adapter
        qrTabs!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (tab.position == 0) {
                    qrParent!!.background =
                        ContextCompat.getDrawable(this@MainActivity, R.drawable.qr_bg)
                    tabFrame!!.background =
                        ContextCompat.getDrawable(this@MainActivity, R.drawable.tab_qr_bg)
                    qrTabs.setTabTextColors(
                        ContextCompat.getColor(this@MainActivity, R.color.app_background),
                        ContextCompat.getColor(this@MainActivity, R.color.text_color)
                    )

                } else {
                    qrTabs.setTabTextColors(
                        ContextCompat.getColor(this@MainActivity, R.color.tab_unselected),
                        ContextCompat.getColor(this@MainActivity, R.color.text_color)
                    )
                    qrParent!!.background =
                        ContextCompat.getDrawable(this@MainActivity, R.drawable.bottom_sheet_bg)
                    tabFrame!!.background =
                        ContextCompat.getDrawable(this@MainActivity, R.drawable.tab_background)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        TabLayoutMediator(
            qrTabs, viewPager!!
        ) { tab, position ->
            if (position == 0) tab.text = "Scan A Code " else tab.text = "My Code"
        }.attach()
    }
}