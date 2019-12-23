package com.dnd.DnDCompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.net.Uri
import com.dnd.DnDCompanion.R
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

        infoButton.setOnClickListener()
        {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://paypal.me/DandDCompanion"))
            startActivity(intent)
        }
    }


}
