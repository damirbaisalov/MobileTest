package com.example.mobiletest.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.mobiletest.R

class RegistrationActivity : AppCompatActivity() {

    private lateinit var accountImageView: ImageView
    private lateinit var accountAddImageButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        initViews()
    }

    private fun initViews() {
        accountImageView = findViewById(R.id.account_image)
        accountAddImageButton = findViewById(R.id.account_add_photo_button)
    }
}