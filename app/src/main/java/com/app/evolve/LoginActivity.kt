package com.app.evolve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import com.app.evolve.customviews.AsteriskPasswordTransformationMethod

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val password = findViewById<AppCompatEditText>(R.id.et_password)
        password.transformationMethod = AsteriskPasswordTransformationMethod()
    }
}