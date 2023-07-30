package com.example.playlistmaker

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchButton = findViewById<View>(R.id.search)
        val searchButtonClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "Нажали на кнопку SEARCH", Toast.LENGTH_SHORT).show()
            }
        }
        searchButton.setOnClickListener(searchButtonClickListener)

        val mediaButton = findViewById<View>(R.id.media)
        mediaButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Нажали на кнопку MEDIA", Toast.LENGTH_SHORT).show()
        }

        val settingsButton = findViewById<View>(R.id.settings)
        settingsButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Нажали на кнопку SETTINGS", Toast.LENGTH_SHORT).show()
        }

    }
}