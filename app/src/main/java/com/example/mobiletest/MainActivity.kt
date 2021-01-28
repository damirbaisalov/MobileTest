package com.example.mobiletest

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import com.example.mobiletest.login.LoginActivity
import java.util.*

private const val TIME_DURATION_PROGRESS = 3000
class MainActivity : AppCompatActivity() {

    private val splashTime: Long = 3000
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progress_bar)

        progressBar.max = TIME_DURATION_PROGRESS
        val currentProgress = TIME_DURATION_PROGRESS
        ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
                .setDuration(splashTime)
                .start()

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTime)
    }
}