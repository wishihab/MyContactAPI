package com.wishihab.mycontactapi.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wishihab.mycontactapi.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        splashscreen by layout and thread
//        setContentView(R.layout.splash_screen_activity)
//        //Handling Splash Screen
//        Handler(Looper.getMainLooper()).postDelayed({
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 3000)
        //best practice to use splashscreen by image
        startActivity(Intent(this@SplashScreen, MainActivity::class.java))
        finish()
    }
}