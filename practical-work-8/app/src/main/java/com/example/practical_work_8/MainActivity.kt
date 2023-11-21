package com.example.practical_work_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val sixteen by lazy {
        findViewById<TextView>(R.id.sixteen)
    }
    private val eight by lazy {
        findViewById<TextView>(R.id.eight)
    }
    private val two by lazy {
        findViewById<TextView>(R.id.two)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)

        savedInstanceState?.let {
            it.getString("sixteen")?.let {
                sixteen.text = it
            }
            it.getString("eight")?.let {
                eight.text = it
            }
            it.getString("two")?.let {
                two.text = it
            }
        }

        button.setOnClickListener(View.OnClickListener {
            val teen = findViewById<EditText>(R.id.editText3)
            val value = teen.text.toString().toIntOrNull()
            if  (value != null && value.toString(16).isNotEmpty()) {
                sixteen.text = value.toString(16)
                eight.text = value.toString(8)
                two.text = value.toString(2)
            } else {
                Toast.makeText(this@MainActivity, R.string.invalidInput, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("sixteen", sixteen.text.toString())
        outState.putString("eight", eight.text.toString())
        outState.putString("two", two.text.toString())

        super.onSaveInstanceState(outState)
    }
}