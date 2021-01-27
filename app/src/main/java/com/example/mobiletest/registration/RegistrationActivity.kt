package com.example.mobiletest.registration

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.widget.*
import com.example.mobiletest.R
import java.util.*
import kotlin.math.sign

const val IMAGE_CODE = 1
class RegistrationActivity : AppCompatActivity() {

    private lateinit var accountImageView: ImageView
    private lateinit var accountAddImageButton: Button
    private lateinit var accountNameEditText: EditText
    private lateinit var accountSurnameEditText: EditText
    private lateinit var accountThirdNameEditText: EditText
    private lateinit var accountDateEditText: EditText
    private lateinit var accountCityEditText: EditText
    private lateinit var accountAboutUserEditText: EditText
    private lateinit var licenseCheckBox: CheckBox
    private lateinit var licenseLinearLayout: LinearLayout
    private lateinit var signUpButton: Button
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

            val dpd = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                accountDateEditText.setText(""+ dayOfMonth + "/" + (monthOfYear + 1) + "/" + year)
            },
                    year,
                    month,
                    day
            )

            dpd.show()
        }
        signUpButton.setOnClickListener {
            if (licenseCheckBox.isChecked && !TextUtils.isEmpty(accountNameEditText.toString()) && !TextUtils.isEmpty(accountSurnameEditText.toString()))
            { toastMessage("Успешная регистрация") }
            else
                if (!licenseCheckBox.isChecked) {
                    toastMessage("Подтвердите пользовательское соглашение")
                } else {
                    toastMessage("Заполните необходимые поля")
                }
        }
    }

    private fun initViews() {
        accountImageView = findViewById(R.id.account_image)
        accountAddImageButton = findViewById(R.id.account_add_photo_button)
        accountDateEditText = findViewById(R.id.account_date)
        accountNameEditText = findViewById(R.id.account_name)
        accountSurnameEditText= findViewById(R.id.account_surname)
        accountThirdNameEditText = findViewById(R.id.account_third_name)
        accountCityEditText = findViewById(R.id.account_city)
        accountAboutUserEditText = findViewById(R.id.account_about)
        licenseCheckBox = findViewById(R.id.checkbox)
        licenseLinearLayout = findViewById(R.id.activity_registration_license_linear_layout)
        signUpButton = findViewById(R.id.activity_registration_sign_up_button)
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

    private fun toastMessage(message: String) {
        val toast = Toast.makeText(
                this,
                message,
                Toast.LENGTH_LONG
        )
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

}