/*
package com.app.evolve.fragments

import android.app.Dialog
import android.hardware.display.DisplayManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import androidx.viewpager2.widget.ViewPager2
import com.app.evolve.R
import com.app.evolve.adapter.viewpager.ViewPagerAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class QRBottomSheetDialog : BottomSheetDialogFragment() {

    companion object {

        const val TAG = "CustomBottomSheetDialogFragment"


        fun newInstance(): QRBottomSheetDialog? {
            return QRBottomSheetDialog()
        }
    }


    protected lateinit var dialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.qr_code, container, false)
    }

    override fun getTheme(): Int {
        return R.style.SheetDialog
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED

        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val metrics = DisplayMetrics()

        val displayManager = requireActivity().getSystemService<DisplayManager>()!!
        val defaultDisplay = displayManager.getDisplay(Display.DEFAULT_DISPLAY)
        defaultDisplay.getRealMetrics(metrics)
        val height = metrics.heightPixels

        val constrainLayout = view.findViewById<ConstraintLayout>(R.id.constrainLayout)
        val qrParent = view.findViewById<LinearLayout>(R.id.qrParent)
        val tabFrame = view.findViewById<FrameLayout>(R.id.tabFrame)
        constrainLayout!!.minHeight = height - 160

        dialog.behavior.peekHeight =  height - 60
        dialog.behavior.isFitToContents = false
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        initQRCode(view, qrParent, tabFrame)
    }

    private fun initQRCode(
        bottomSheetDialog: View,
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
                        ContextCompat.getDrawable(context!!, R.drawable.qr_bg)
                    tabFrame!!.background =
                        ContextCompat.getDrawable(context!!, R.drawable.tab_qr_bg)
                    qrTabs.setTabTextColors(
                        ContextCompat.getColor(context!!, R.color.app_background),
                        ContextCompat.getColor(context!!, R.color.text_color)
                    )

                } else {
                    qrTabs.setTabTextColors(
                        ContextCompat.getColor(context!!, R.color.tab_unselected),
                        ContextCompat.getColor(context!!, R.color.text_color)
                    )
                    qrParent!!.background =
                        ContextCompat.getDrawable(context!!, R.drawable.bottom_sheet_bg)
                    tabFrame!!.background =
                        ContextCompat.getDrawable(context!!, R.drawable.tab_background)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        TabLayoutMediator(
            qrTabs, viewPager!!
        ) { tab, position ->
            if (position == 0) tab.text = "Scan" else tab.text = "My Code"
        }.attach()
    }
}*/
