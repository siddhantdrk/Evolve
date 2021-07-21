package com.app.evolve.customviews

import android.text.method.PasswordTransformationMethod
import android.view.View

class AsteriskPasswordTransformationMethod : PasswordTransformationMethod() {

    override fun getTransformation(source: CharSequence?, view: View?): CharSequence {
        return PasswordCharSequence(source)
    }

    private class PasswordCharSequence(
        private val mSource: CharSequence?
    ) : CharSequence {
        override val length: Int
            get() = mSource!!.length

        override fun get(index: Int): Char {
            return '*'; // Return default
        }

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
            return mSource!!.subSequence(startIndex, endIndex);
        }

    }
}