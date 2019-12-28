package com.dnd.DnDCompanion

import android.app.AlertDialog
import android.content.DialogInterface
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
            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/GuysApps"))

            // set message of alert dialog
            dialogBuilder.setMessage(("Give the developers of D&D Companion your support by visiting " +
                    "our twitter and sharing your suggestions and ideas with us! We do want to make " +
                    "this app better and can't do it without your help!"))
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Twitter", DialogInterface.OnClickListener {
                        dialog, id -> startActivity(intent)
                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("Contact the Developers?")
            // show alert dialog
            alert.show()
        }
    }


}
