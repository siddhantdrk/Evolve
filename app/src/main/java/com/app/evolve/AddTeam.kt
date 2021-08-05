package com.app.evolve

import android.hardware.display.DisplayManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.getSystemService
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.card.MaterialCardView


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
        val height =  metrics.heightPixels
        val bottomSheetDialog = BottomSheetDialog(this, R.style.SheetDialog)
        bottomSheetDialog.setContentView(R.layout.select_team)
        val constrainLayout = bottomSheetDialog.findViewById<ConstraintLayout>(R.id.constrainLayout)
        constrainLayout!!.minHeight = height
        bottomSheetDialog.behavior.isFitToContents = false
        bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetDialog.show()
    }
}