package com.example.mobiletest.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mobiletest.MainActivity
import com.example.mobiletest.R
import com.example.mobiletest.registration.RegistrationActivity
import com.example.mobiletest.support.presentation.SupportServiceActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var signUpButton: Button
    private lateinit var supportButton: Button
    private lateinit var skipButton: Button

    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViews()

        loginButton.setOnClickListener {
            when {
                TextUtils.isEmpty(loginEditText.text.toString()) -> Toast.makeText(
                    this,
                    "Ошибка! Введите логин",
                    Toast.LENGTH_LONG
                ).show()
                TextUtils.isEmpty(passwordEditText.text.toString()) -> Toast.makeText(
                    this,
                    "Ошибка! Введите пароль",
                    Toast.LENGTH_LONG
                ).show()
                else -> Toast.makeText(
                    this,
                    "Ошибка! Неверный логин и пароль",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        signUpButton.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
        supportButton.setOnClickListener {
            val intent = Intent(this, SupportServiceActivity::class.java)
            startActivity(intent)
        }
        skipButton.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }
    }

    private fun initViews() {
        loginButton = findViewById(R.id.login_button)
        signUpButton = findViewById(R.id.sign_up_button)
        supportButton = findViewById(R.id.activity_login_support_button)
        skipButton = findViewById(R.id.activity_login_skip_button)
        loginEditText = findViewById(R.id.login_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
    }
}