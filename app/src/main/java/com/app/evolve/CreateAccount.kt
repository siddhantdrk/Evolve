package com.app.evolve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatEditText
import com.app.evolve.customviews.AsteriskPasswordTransformationMethod

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val password = findViewById<AppCompatEditText>(R.id.et_password)
        password.transformationMethod = AsteriskPasswordTransformationMethod()

        val et_confirm_password = findViewById<AppCompatEditText>(R.id.et_confirm_password)
        et_confirm_password.transformationMethod = AsteriskPasswordTransformationMethod()
    }
}