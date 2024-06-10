package com.st10440057.st10440057_imad5112_practicum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val HomeButton = findViewById<Button>(R.id.btnHome)     //linking buttons from home screen
        val ExitButton = findViewById<Button>(R.id.btnExit)

        HomeButton.setOnClickListener {
            val intent = Intent(this@SplashScreen, HomePage::class.java)
            startActivity(intent)


            }//end of HomeButton
        ExitButton.setOnClickListener { finish() } //closing application


    }//end of override
}//end of main