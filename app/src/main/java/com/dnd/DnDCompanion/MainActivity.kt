package com.dnd.DnDCompanion

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dnd.DnDCompanion.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_menu.*


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
        val resultString = findViewById<TextView>(R.id.resultView)

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

        rollButton.setOnClickListener{

            // Roll Functions to roll any combination of the dice
            rollFour()
            rollSix()
            rollEight()
            rollTen()
            rollTwelve()
            rollTwenty()


                if( totalSum != 0) {
                    if(modifier.text.toString()!="") {
                        totalSum += modifier.text.toString().toInt()
                    }
                    resultString.setText(totalSum.toString())
                }
                else{
                    resultString.setText("No Dice Selected")
                }
                totalSum = 0

        }

        imageButtonD4.setOnClickListener(){

            resultString.setText(((1..4).random()).toString())
        }
        imageButtonD6.setOnClickListener(){
            resultString.setText(((1..6).random()).toString())
        }
        imageButtonD8.setOnClickListener(){
            resultString.setText(((1..8).random()).toString())
        }
        imageButtonD10.setOnClickListener(){
            resultString.setText(((1..10).random()).toString())
        }
        imageButtonD12.setOnClickListener(){
            resultString.setText(((1..12).random()).toString())
        }
        imageButtonD20.setOnClickListener(){
            resultString.setText(((1..20).random()).toString())
        }

        clearButton.setOnClickListener(){
            d4Number.setText("0")
            d6Number.setText("0")
            d8Number.setText("0")
            d10Number.setText("0")
            d12Number.setText("0")
            d20Number.setText("0")
            modifier.setText("0")
        }

        helpButton.setOnClickListener()
        {
            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this)
            // set message of alert dialog
            dialogBuilder.setMessage(
                ("Quick Roll: To quick roll a die, tap on the icon of the die that you would like to roll. \n" +
                        "Multiple Dice: To roll multiple dice, enter the number of dice that you " +
                        "would like to roll and then tap the ROLL button. \n" +
                        "Modifier: If you have a modifier that you would like added to your roll enter" +
                        "a value into the MODIFIER box to have it applied to the total.")
            )
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Okay!", DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                })
                // negative button text and action
                .setNegativeButton("", DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("How to Use")
            // show alert dialog
            alert.show()
        }
    }

}
