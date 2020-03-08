package com.example.practicalwork8

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

    fun convertButtonClick(view: View)
    {
        val converter = UserNumConverter()
        // Из двоичного в десятичную
        if (converter.from2To10(NumText.text.toString()) != null)
        {
            result2.text = converter.from2To10(NumText.text.toString()).toString()
        }
        else
        {
            result2.text = "Некорректное значение"
        }
        // Из восьмеричной в дясетичную
        if (converter.from8To10(NumText.text.toString()) != null)
        {
            result8.text = converter.from8To10(NumText.text.toString()).toString()
        }
        else
        {
            result8.text = "Некорректное значение"
        }
        // Из восьмеричной в дясетичную
        if (converter.from16To10(NumText.text.toString()) != null)
        {
            result16.text = converter.from16To10(NumText.text.toString()).toString()
        }
        else
        {
            result16.text = "Некорректное значение"
        }
    }
}

class UserNumConverter
{
    fun from2To10( num: String ): Double?
    {
        if (Regex("""^[01]*$""").find(num) != null)
        {
            var i = num.length - 1
            return num.fold(0.0) {total, next ->
                total + 2.0.pow(i--) * next.toString().toInt() }
        }
        else
        {
            return null
        }
    }

    fun from8To10( num: String ): Double?
    {
        if (Regex("""^[01234567]*$""").find(num) != null)
        {
            var i = num.length - 1
            return num.fold(0.0) {total, next ->
                total + 8.0.pow(i--) * next.toString().toInt() }
        }
        else
        {
            return null
        }
    }

    fun from16To10( num: String ): Double?
    {
        if (Regex("""^([0123456789]|[A-F]|[a-f])*$""").find(num) != null)
        {
            var i = num.length - 1
            return num.fold(0.0) { total, next ->
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
            }
        }
        else
        {
            return null
        }
    }

}