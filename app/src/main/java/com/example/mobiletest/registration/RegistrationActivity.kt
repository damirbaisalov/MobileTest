package com.example.mobiletest.registration

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.mobiletest.R
import java.util.*

const val IMAGE_CODE = 1
class RegistrationActivity : AppCompatActivity() {

    private lateinit var accountImageView: ImageView
    private lateinit var accountAddImageButton: Button
    private lateinit var accountDateEditText: EditText
    private var uriData: Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        initViews()
        accountAddImageButton.setOnClickListener {
            openImageForm()
        }
        accountDateEditText.isFocusable = false
        accountDateEditText.setOnClickListener {
            val calendarData = Calendar.getInstance()
            val day = calendarData.get(Calendar.DAY_OF_MONTH)
            val month = calendarData.get(Calendar.MONTH)
            val year = calendarData.get(Calendar.YEAR)

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                accountDateEditText.setText(""+ dayOfMonth + "/" + (monthOfYear + 1) + "/" + year)
            }, year, month, day)

            dpd.show()
        }
    }

    private fun initViews() {
        accountImageView = findViewById(R.id.account_image)
        accountAddImageButton = findViewById(R.id.account_add_photo_button)
        accountDateEditText = findViewById(R.id.account_date)
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