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
                putExtra(Intent.EXTRA_TEXT, "https://practicum.yandex.ru/android-developer/")
                type = "text/plain"
            }
            startActivity(settingsShareIntent)
        }

        // Кнопка написать в поддержку
        val settingsCallSupportButton = findViewById<View>(R.id.settings_call_support)
        settingsCallSupportButton.setOnClickListener {
            val subject = "Сообщение разработчикам и разработчицам приложения Playlist Maker"
            val message = "Спасибо разработчикам и разработчицам за крутое приложение!"
            val settingsCallSupportIntent = Intent(Intent.ACTION_SENDTO)
            settingsCallSupportIntent.data = Uri.parse("mailto:")
            settingsCallSupportIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("monitor1010@yandex.ru"))
            settingsCallSupportIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            settingsCallSupportIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(settingsCallSupportIntent)
        }

        // Кнопка пользовательское соглашение
        val settingsUserAgreementButton = findViewById<View>(R.id.settings_user_agreement)
        settingsUserAgreementButton.setOnClickListener {
            val url = Uri.parse("https://yandex.ru/legal/practicum_termsofuse/")
            val settingsUserAgreementintent = Intent(Intent.ACTION_VIEW, url)
            startActivity(settingsUserAgreementintent)
        }
    }
}