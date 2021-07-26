package com.app.evolve

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.app.evolve.customviews.HorizontalMarginItemDecoration
import com.app.evolve.onboarding.ViewPagerFragmentAdapter
import java.lang.Math.abs


class OnBoarding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        val rv_borading = findViewById<ViewPager2>(R.id.rv_borading)
        val adapter = ViewPagerFragmentAdapter(this)
        rv_borading.adapter = adapter
        rv_borading.offscreenPageLimit = 1
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            page.scaleY = 1 - (0.0f * abs(position))
        }
        rv_borading.setPageTransformer(pageTransformer)
        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        rv_borading.addItemDecoration(itemDecoration)
    }

}