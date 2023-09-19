package com.example.playlistmaker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout

class SearchActivity : AppCompatActivity() {

    var searchInputText: String = ""

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(SEARCH_INPUT_TEXT, searchInputText)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        searchInputText = savedInstanceState.getString(SEARCH_INPUT_TEXT, "")
        super.onRestoreInstanceState(savedInstanceState)
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val searchBackButton = findViewById<View>(R.id.search_back)
        searchBackButton.setOnClickListener { finish() }

        val activitySearchLinearLayout = findViewById<LinearLayout>(R.id.container_search)
        val activitySearchEditText = findViewById<EditText>(R.id.activitySearchEditText)
        val activitySearchClearIcon = findViewById<ImageView>(R.id.activitySearchClearIcon)

        activitySearchClearIcon.setOnClickListener {
            activitySearchEditText.setText("")
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            val view = this.getCurrentFocus()
            if (view != null) {
                inputMethodManager?.hideSoftInputFromWindow(view.windowToken, 0)
            }
         }

        val activitySearchTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // empty
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty()) {
                    // do nothing
                } else {
                    searchInputText = s.toString()
                }
                activitySearchClearIcon.visibility = clearButtonVisibility(s)
            }

            override fun afterTextChanged(s: Editable?) {
                // empty
            }

            private fun clearButtonVisibility(s: CharSequence?): Int {
                return if (s.isNullOrEmpty()) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
            }

        }
        activitySearchEditText.addTextChangedListener(activitySearchTextWatcher)
    }

    companion object {
        const val SEARCH_INPUT_TEXT = "SEARCH_INPUT_TEXT"
    }
}
