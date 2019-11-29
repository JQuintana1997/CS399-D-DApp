package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        toDiceButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        toCharNotes.setOnClickListener{
            val intent = Intent(this, CharNotes::class.java)
            startActivity(intent)
        }
    }


}
