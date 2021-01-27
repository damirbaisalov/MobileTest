package com.example.mobiletest.support.presentation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mobiletest.R
import java.lang.Exception

private const val SUPPORT_TELEPHONE_NUMBER = "tel:+77013299400"
private const val SUPPORT_EMAIL = "support@app.kz"
private const val MESSAGE_SUCCESS = "Сообщение отправлено"
private const val MESSAGE_FAIL = "Заполните поле"
class SupportServiceActivity : AppCompatActivity() {

    private lateinit var telephoneCallButton: Button
    private lateinit var supportEmailButton: Button
    private lateinit var supportSendMessageButton: Button
    private lateinit var supportServiceEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support_service)

        initViews()

        telephoneCallButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(SUPPORT_TELEPHONE_NUMBER)
            startActivity(intent)
        }

        supportEmailButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(SUPPORT_EMAIL))
            intent.type = "message/rfc822"
            try {
               startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
            }
        }

        supportSendMessageButton.setOnClickListener {
            if (!TextUtils.isEmpty(supportServiceEditText.text.toString())) {
                toastMessage(MESSAGE_SUCCESS)
                supportServiceEditText.text.clear()
            } else {
               toastMessage(MESSAGE_FAIL)
            }
        }
    }

    private fun initViews() {
        supportServiceEditText = findViewById(R.id.activity_support_service_edit_text)
        telephoneCallButton = findViewById(R.id.activity_support_service_telephone)
        supportSendMessageButton = findViewById(R.id.activity_support_service_send_message_button)
        supportEmailButton = findViewById(R.id.activity_support_service_email)
        supportServiceEditText.isFocusableInTouchMode = true
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