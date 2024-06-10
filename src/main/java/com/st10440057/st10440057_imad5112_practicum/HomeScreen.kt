package com.st10440057.st10440057_imad5112_practicum

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        var numMaxTempArr = arrayOfNulls<Double>(7)
        var numMaxTemp = findViewById<EditText>(R.id.etWeatherMax)  //linking max temp

        var numMinTempArr = arrayOfNulls<Double>(7)
        var numMinTemp = findViewById<EditText>(R.id.etWeatherMin)  //linking min temp

        var strConditionArr = arrayOfNulls<String>(7)
        var strConditions = findViewById<EditText>(R.id.etConditions)   //linking conditions


    }

    




}