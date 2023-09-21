package com.example.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
                val searchButton = findViewById<View>(R.id.buttonSearch)
                val searchButtonClickListener: View.OnClickListener = object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        Toast.makeText(this@MainActivity, "Нажали на кнопку SEARCH", Toast.LENGTH_SHORT).show()
                    }
                }
                searchButton.setOnClickListener(searchButtonClickListener)
         */

        val searchButton = findViewById<View>(R.id.buttonSearch)
        searchButton.setOnClickListener {
            val searchIntent = Intent(this, SearchActivity::class.java)
            startActivity(searchIntent)
        }

        val mediaButton = findViewById<View>(R.id.buttonMedia)
        mediaButton.setOnClickListener {
            val mediaIntent = Intent(this, MediaActivity::class.java)
            startActivity(mediaIntent)
            //           Toast.makeText(this@MainActivity, "Нажали на кнопку MEDIA", Toast.LENGTH_SHORT).show()
        }

        val settingsButton = findViewById<View>(R.id.buttonSettings)
        settingsButton.setOnClickListener {
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            startActivity(settingsIntent)
            //           Toast.makeText(this@MainActivity, "Нажали на кнопку SETTINGS", Toast.LENGTH_SHORT).show()
        }

    }
}