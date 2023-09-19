package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val settingsBackButton = findViewById<View>(R.id.settings_back)
        settingsBackButton.setOnClickListener { finish() }

        // Кнопка поделиться приложением
        val settingsShareButton = findViewById<View>(R.id.settings_share)
        settingsShareButton.setOnClickListener {
            val settingsShareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,getString(R.string.settingsShareButtonPrompt))
                type = "text/plain"
            }
            startActivity(settingsShareIntent)
        }

        // Кнопка написать в поддержку
        val settingsCallSupportButton = findViewById<View>(R.id.settings_call_support)
        settingsCallSupportButton.setOnClickListener {
            val settingsCallSupportIntent = Intent(Intent.ACTION_SENDTO)
            settingsCallSupportIntent.data = Uri.parse("mailto:")
            settingsCallSupportIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.settingsCallSupportFrom)))
            settingsCallSupportIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.settingsCallSupportSubject))
            settingsCallSupportIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.settingsCallSupportMessage))
            startActivity(settingsCallSupportIntent)
        }

        // Кнопка пользовательское соглашение
        val settingsUserAgreementButton = findViewById<View>(R.id.settings_user_agreement)
        settingsUserAgreementButton.setOnClickListener {
            val url = Uri.parse (getString(R.string.settingsShareButtonPrompt))
            val settingsUserAgreementintent = Intent(Intent.ACTION_VIEW, url)
            startActivity(settingsUserAgreementintent)
        }
    }
}