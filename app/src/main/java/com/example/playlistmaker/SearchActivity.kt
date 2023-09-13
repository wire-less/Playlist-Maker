package com.example.playlistmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout

class SearchActivity : AppCompatActivity() {

public var searchInputText: String = ""
companion object {
    const val SEARCH_INPUT_TEXT = "SEARCH_INPUT_TEXT"
}
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SEARCH_INPUT_TEXT, searchInputText)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        searchInputText = savedInstanceState.getString(SEARCH_INPUT_TEXT,"")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val activitySearchLinearLayout = findViewById<LinearLayout>(R.id.container_search)
        val activitySearchEditText = findViewById<EditText>(R.id.activitySearchEditText)
        val activitySearchClearIcon = findViewById<ImageView>(R.id.activitySearchClearIcon)

        activitySearchClearIcon.setOnClickListener {
            activitySearchEditText.setText(searchInputText)
        }

val activitySearchTextWatcher = object : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    // empty
}

override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    if (s.isNullOrEmpty()) {
    // do something
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
        // business if here
        activitySearchEditText.addTextChangedListener(activitySearchTextWatcher)
    }
}


/*
//Код ниже может скрыть клавиатуру:
val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
inputMethodManager?.hideSoftInputFromWindow(`currentView`.windowToken, 0)
 */