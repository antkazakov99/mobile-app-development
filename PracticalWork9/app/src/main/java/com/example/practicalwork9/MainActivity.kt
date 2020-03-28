package com.example.practicalwork9

import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import kotlinx.android.synthetic.main.activity_add_tariff.*
import kotlinx.android.synthetic.main.activity_main.*

val tariffs = mutableListOf<Tariff>()

// Класс "Тарифы
class Tariff
{
    var id: Int = 0
    // Название тарифа
    var name: String = "default"
    // Тип вещания
    var hdBroadcast: Boolean = false
    // Флаг общедоступности
    var publicAccess: Boolean = true
    // Фото для 11 практической
    var image: Bitmap? = null

}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addTariffButtonClick(view: View) {
        startActivity(Intent(this, AddTariff::class.java))
    }

    fun showTariffsButtonClick(view: View) {
        startActivity(Intent(this, ShowTariffs::class.java))
    }

}
