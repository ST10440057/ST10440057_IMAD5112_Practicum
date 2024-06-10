package com.st10440057.st10440057_imad5112_practicum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DaySummery : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_summery)

        var tvMax = findViewById<TextView>(R.id.tvMaxTemp)  //Linking TextViews
        var tvMin = findViewById<TextView>(R.id.tvMinTemp)
        var tvDay = findViewById<TextView>(R.id.tvDay)
        var tvCondition = findViewById<TextView>(R.id.tvConditions)

        val btnExit = findViewById<Button>(R.id.btnExit)    //Linking Buttons
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnSerch = findViewById<Button>(R.id.btnSerch)

        var etDayNum = findViewById<EditText>(R.id.etDayNum) //linking to editText

        var day =""
        var dayNum = 0
        val MaxTemp = HomeScreen().numMaxTempArr    //linking to HomeScreen
        val MinTemp = HomeScreen().numMinTempArr
        val Conditions = HomeScreen().strConditionArr

        dayNum = etDayNum.text.toString().toInt()//Getting the day

        if(dayNum != 1 || dayNum != 2 || dayNum != 3||dayNum != 4||dayNum != 5||dayNum != 6||dayNum != 7){
        etDayNum.error = "Number is not correct"
        }


        getDay(dayNum)

        btnSerch.setOnClickListener {

            tvDay.text = "Day: " + day
            tvMax.text = "Max Temperature: " + MaxTemp[dayNum-1]
            tvMin.text = "Min Temperature: "+ MinTemp[dayNum-1]
            tvCondition.text = "Conditions: " + Conditions[dayNum-1]

        }

        btnBack.setOnClickListener { val intent = Intent(this@DaySummery, HomeScreen::class.java)
            startActivity(intent) } // switching to home screen

        btnExit.setOnClickListener { finish() } //exiting application


    }

    private fun getDay(x:Int) :String {
        var day = ""

        when (x) {
            1 -> day = "Monday"
            2 -> day = "Tuesday"
            3 -> day = "Wednesday"
            4 -> day = "Thursday"
            5 -> day = "Friday"
            6 -> day = "Saturday"
            7 -> day = "Sunday"
        }//end when#1
        return day
    }

}