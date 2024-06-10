package com.st10440057.st10440057_imad5112_practicum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeScreen : AppCompatActivity() {

    public var strConditionArr = arrayOfNulls<String?>(7)
    public var numMinTempArr = arrayOfNulls<String?>(7)
    public var numMaxTempArr = arrayOfNulls<String?>(7)
    public var strDay = "Monday"
    public var Count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        var numMaxTemp = findViewById<EditText>(R.id.etWeatherMax)  //linking max temp
        var numMinTemp = findViewById<EditText>(R.id.etWeatherMin)  //linking min temp
        var strConditions = findViewById<EditText>(R.id.etConditions)   //linking conditions
        val btnExit = findViewById<Button>(R.id.btnExit)    //linking exit button
        val btnDay = findViewById<Button>(R.id.btnReport)    //linking daily button
        val btnUpdate = findViewById<Button>(R.id.btnAdd)   //linking add button
        var tvAverage = findViewById<TextView>(R.id.tvAverage) // linking Average output
        val btnClear = findViewById<Button>(R.id.btnClear)  //Linking Clear Button

        btnUpdate.setOnClickListener {

            strDay = getDay(Count + 1)
            tvAverage.text = "Average Temperature: " + AverageTemp(numMaxTempArr,numMinTempArr)

            if(Count <= 7){ //Assigning inputs to the array
                updateCondition(strConditions.text.toString())
                updateMax(numMaxTemp.text.toString())
                updateMin(numMinTemp.text.toString())
                Count++
            }//end if if #1

        }//end of btnUpdate on click listener

    btnExit.setOnClickListener { finish() } // closing the app

    btnDay.setOnClickListener { // switching to DaySummary
        val intent = Intent(this@HomeScreen, DaySummery::class.java)
        startActivity(intent)
    }//end of btnDaily oin click listener

    btnClear.setOnClickListener { clearArrays() }//clearing the arrays


    }//end of override



    private fun updateMax(i:String){

            numMaxTempArr[Count-1] = i

    }   //end updateMax
    private fun updateMin(i:String){


        numMinTempArr[Count-1] = i

    }//end updateMin
    private fun updateCondition(i:String){

        strConditionArr[Count-1] = i

    }//end updateConditio0n

    private fun AverageTemp(i:Array<String?>,a:Array<String?>): String {
        var numAvg = 0.0
        var count = 0
        for(count in 0..7){
          numAvg = numAvg+ i[count]!!.toDouble() + a[count]!!.toDouble()
        }//end for#1

        numAvg = numAvg/(count*2)
        return numAvg.toString()
    }//end Average Temp

    private fun getDay(x:Int) :String{
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
    }//end getDay
    private fun clearArrays(){

        val flag = 0
        while (flag <= numMinTempArr.size){

            numMaxTempArr[flag] = null
            numMinTempArr[flag] = null
            strConditionArr[flag] = null


        }//end of while #1
    }//end clearArrays



}//end of main
