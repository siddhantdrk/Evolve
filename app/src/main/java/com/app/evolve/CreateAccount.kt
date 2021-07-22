package com.app.evolve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import com.app.evolve.customviews.AsteriskPasswordTransformationMethod

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val password = findViewById<EditText>(R.id.et_password)
        password.transformationMethod = AsteriskPasswordTransformationMethod()

        val et_confirm_password = findViewById<EditText>(R.id.et_confirm_password)
        et_confirm_password.transformationMethod = AsteriskPasswordTransformationMethod()

        findViewById<TextView>(R.id.tv_request_access).setOnClickListener {
            val intent = Intent(this@CreateAccount, RequestSent::class.java)
            startActivity(intent)
        }

    }
}