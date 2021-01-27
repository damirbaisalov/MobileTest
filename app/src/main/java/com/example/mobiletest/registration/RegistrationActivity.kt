package com.example.mobiletest.registration

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.mobiletest.R

const val IMAGE_CODE = 1
class RegistrationActivity : AppCompatActivity() {

    private lateinit var accountImageView: ImageView
    private lateinit var accountAddImageButton: Button
    private var uriData: Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        initViews()
        accountAddImageButton.setOnClickListener {
            openImageForm()
        }

    }

    private fun initViews() {
        accountImageView = findViewById(R.id.account_image)
        accountAddImageButton = findViewById(R.id.account_add_photo_button)
    }

    private fun openImageForm() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, IMAGE_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode== IMAGE_CODE && resultCode== RESULT_OK && data!=null && data.data!=null) {

            uriData = data.data
            accountImageView.setImageURI(uriData)
        }
    }

}