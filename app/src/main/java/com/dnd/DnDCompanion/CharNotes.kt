package com.dnd.DnDCompanion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_char_notes.*
import kotlinx.android.synthetic.main.activity_char_notes.armorBox
import kotlinx.android.synthetic.main.activity_char_notes.charTextbox
import kotlinx.android.synthetic.main.activity_char_notes.charToDice
import kotlinx.android.synthetic.main.activity_char_notes.healthBox
import kotlinx.android.synthetic.main.activity_char_notes.initiativeBox
import kotlinx.android.synthetic.main.activity_char_notes.saveButton
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
        // Saving Name, Level, Class
        val name = nameBox.text.toString()
        val level = levelBox.text.toString()
        val charClass = classBox.text.toString()
        //Saving HP, AC, and Initiative
        val maxHealth = maxHealthBox.text.toString()
        val health = healthBox.text.toString()
        val armor = armorBox.text.toString()
        val initiative = initiativeBox.text.toString()
        // Saving the text put into the charTextBox component
        val noteText = charTextbox.text.toString()
        //Edits shared preferences (to put data)
        val editor = sharedPreferences.edit()
        //Put data in shared preferences
        editor.putString("MAXHEALTH", maxHealth)
        editor.putString("NAME", name)
        editor.putString("LEVEL", level)
        editor.putString("CLASS", charClass)
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
        val maxHealth = sharedPreferences.getString("MAXHEALTH", "MAX HP")
        val name = sharedPreferences.getString("NAME", "NAME")
        val level = sharedPreferences.getString("LEVEL", "LEVEL")
        val charClass = sharedPreferences.getString("CLASS", "CLASS")

        // Changes all the editText components to their saved values
        charTextbox.setText(noteText)
        armorBox.setText(armor)
        healthBox.setText(health)
        initiativeBox.setText(initiative)
        maxHealthBox.setText(maxHealth)
        nameBox.setText(name)
        levelBox.setText(level)
        classBox.setText(charClass)

    }


}
