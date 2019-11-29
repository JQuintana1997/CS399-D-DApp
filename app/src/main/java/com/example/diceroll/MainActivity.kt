package com.example.diceroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            backToMenu.setOnClickListener{
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            }

            diceToNotes.setOnClickListener{
                val intent = Intent(this, CharNotes::class.java)
                startActivity(intent)
            }
        // This is the total sum that will be displayed as the result when dice are rolled
        var totalSum = 0





        rollButton.setOnClickListener{

            // CURRENT ISSUE WITH THE PROGRAM! IF ANY OF THE EDITTEXT FIELDS ARE EMPTY,
            // THE PROGRAM WILL CRASH

            fun rollFour(){
                //This turns the EditText data into an int to be used for our while loop
                if ( d4Number.text.toString() != "" ) {
                    val dFour: Int = d4Number.text.toString().toInt()

                    //Keeps track of while loop iterations
                    var dFourCount = 0
                    // Will generate a random number n amount of times and add it to the totalSum
                    while (dFour > dFourCount) {

                        val randomValsFour = (1..4).random()
                        totalSum += randomValsFour
                        dFourCount += 1

                    }
                }
            }

            fun rollSix() {
                //This turns the EditText data into an int to be used for our while loop
                if ( d6Number.text.toString() != "" ) {
                    val dSix: Int = d6Number.text.toString().toInt()
                    //Keeps track of while loop iterations
                    var dSixCount = 0
                    // Will generate a random number n amount of times and add it to the totalSum
                    while (dSix > dSixCount) {

                        val randomValsSix = (1..6).random()
                        totalSum += randomValsSix
                        dSixCount += 1
                    }
                }
            }

            fun rollEight() {
                //This turns the EditText data into an int to be used for our while loop
                if ( d8Number.text.toString() != "" ) {
                    val dEight: Int = d8Number.text.toString().toInt()
                    //Keeps track of while loop iterations
                    var dEightCount = 0
                    // Will generate a random number n amount of times and add it to the totalSum
                    while (dEight > dEightCount) {

                        val randomValsEight = (1..8).random()
                        totalSum += randomValsEight
                        dEightCount += 1
                    }
                }
            }

            fun rollTen() {
                //This turns the EditText data into an int to be used for our while loop
                if ( d10Number.text.toString() != "" ) {
                    val dTen: Int = d10Number.text.toString().toInt()
                    //Keeps track of while loop iterations
                    var dTenCount = 0
                    // Will generate a random number n amount of times and add it to the totalSum
                    while (dTen > dTenCount) {

                        val randomValsTen = (1..10).random()
                        totalSum += randomValsTen
                        dTenCount += 1
                    }
                }
            }

            fun rollTwelve() {
                //This turns the EditText data into an int to be used for our while loop
                if ( d12Number.text.toString() != "" ) {
                    val dTwelve: Int = d12Number.text.toString().toInt()
                    //Keeps track of while loop iterations
                    var dTwelveCount = 0
                    // Will generate a random number n amount of times and add it to the totalSum
                    while (dTwelve > dTwelveCount) {

                        val randomValsTwelve = (1..12).random()
                        totalSum += randomValsTwelve
                        dTwelveCount += 1
                    }
                }
            }

            fun rollTwenty(){
                //This turns the EditText data into an int to be used for our while loop
                if ( d20Number.text.toString() != "" ) {
                    val dTwenty: Int = d20Number.text.toString().toInt()
                    //Keeps track of while loop iterations
                    var dTwentyCount = 0
                    // Will generate a random number n amount of times and add it to the totalSum
                    while (dTwenty > dTwentyCount) {

                        val randomValsTwenty = (1..20).random()
                        totalSum += randomValsTwenty
                        dTwentyCount += 1
                    }
                }
            }

            rollFour()
            rollSix()
            rollEight()
            rollTen()
            rollTwelve()
            rollTwenty()

                val resultString = findViewById<TextView>(R.id.resultView)
                if( totalSum != 0) {
                    resultString.setText(totalSum.toString())
                }
                else{
                    resultString.setText("No Dice Selected")
                }
                totalSum = 0

        }

    }

}
