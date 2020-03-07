package com.example.practicalwork7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe(view: View)
    {
        NumText.text
        // Из двоичного в десятичную
        if (Regex("""^[01]*$""").find(NumText.text) != null)
        {
            var i = NumText.text.length - 1
            result2.text = NumText.text.fold(0.0) {total, next ->
                total + 2.0.pow(i--) * next.toString().toInt()
            }.toString()
        }
        else
        {
            result2.text = "Некорректное значение"
        }
        // Из восьмеричной в дясетичную
        if (Regex("""^[01234567]*$""").find(NumText.text) != null)
        {
            var i = NumText.text.length - 1
            result8.text = NumText.text.fold(0.0) {total, next ->
                total + 8.0.pow(i--) * next.toString().toInt()
            }.toString()
        }
        else
        {
            result8.text = "Некорректное значение"
        }
        // Из восьмеричной в дясетичную
        if (Regex("""^([0123456789]|[A-F]|[a-f])*$""").find(NumText.text) != null)
        {
            var i = NumText.text.length - 1
            result16.text = NumText.text.fold(0.0) {total, next ->
                when (next)
                {
                    'A','a' -> total + 16.0.pow(i--) * 10
                    'B','b' -> total + 16.0.pow(i--) * 11
                    'C','c' -> total + 16.0.pow(i--) * 12
                    'D','d' -> total + 16.0.pow(i--) * 13
                    'E','e' -> total + 16.0.pow(i--) * 14
                    'F','f' -> total + 16.0.pow(i--) * 15
                    else -> total + 16.0.pow(i--) * next.toString().toInt()
                }
            }.toString()
        }
        else
        {
            result16.text = "Некорректное значение"
        }
    }

}
