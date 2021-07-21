package com.app.evolve.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Typeface
import android.util.AttributeSet
import com.app.evolve.R

class LatoLigthTextView : androidx.appcompat.widget.AppCompatTextView {


    constructor(context: Context) : super(context) {
        val face = Typeface.createFromAsset(context.assets, context.getString(R.string.lato_ligth))
        this.typeface = face
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val face = Typeface.createFromAsset(context.assets, context.getString(R.string.lato_ligth))
        this.typeface = face
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        val face = Typeface.createFromAsset(context.assets, context.getString(R.string.lato_ligth))
        this.typeface = face
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }
}