package com.example.mobiletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import com.example.mobiletest.login.LoginActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private val splashTime: Long = 3000
    private lateinit var progressBar: ProgressBar
    private lateinit var timer: Timer
    private val counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progress_bar)
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTime)
    }
//        Thread{
//                doLoadingWork()
//                val intent = Intent(this@MainActivity, LoginActivity::class.java)
//                startActivity(intent)
//                finish()
//        }.run()
//    }
//
//    private fun doLoadingWork() {
//        for(progress in 0..50 step 10){
//            try{
//                Thread.sleep(1000)
//                progressBar.progress = progress
//            } catch (e: Exception) {
//                Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show()
//            }
//        }
//    }
}