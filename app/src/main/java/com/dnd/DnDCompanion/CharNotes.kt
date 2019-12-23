package com.dnd.DnDCompanion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import com.dnd.DnDCompanion.R
import kotlinx.android.synthetic.main.activity_char_notes.*
import kotlinx.android.synthetic.main.activity_main.backToMenu


class CharNotes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_char_notes)


        backToMenu.setOnClickListener{
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
        charToDice.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        saveButton.setOnClickListener{
            saveData()
        }

        loadData()

    }

    private fun saveData(){

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        //Saving HP, AC, and Initiative
        val health = healthBox.text.toString()
        val armor = armorBox.text.toString()
        val initiative = initiativeBox.text.toString()
        // Saving the text put into the charTextBox component
        val noteText = charTextbox.text.toString()
        //Edits shared preferences (to put data)
        val editor = sharedPreferences.edit()
        //Put data in shared preferences
        editor.putString("NOTES", noteText)
        editor.putString("HEALTH", health)
        editor.putString("ARMOR", armor)
        editor.putString("INITIATIVE", initiative)
        //Apply changes to shared preferences
        editor.apply()

        // Displays a message at the bottom stating that the save was successful
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show()

    }

    private fun loadData(){

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        //get data from shared preferences
        val noteText = sharedPreferences.getString("NOTES", "Enter Notes")
        val armor = sharedPreferences.getString("ARMOR", "AC")
        val health = sharedPreferences.getString("HEALTH", "HP")
        val initiative = sharedPreferences.getString("INITIATIVE", "INT")
        // Changes all the editText components to their saved values
        charTextbox.setText(noteText)
        armorBox.setText(armor)
        healthBox.setText(health)
        initiativeBox.setText(initiative)

    }


}
