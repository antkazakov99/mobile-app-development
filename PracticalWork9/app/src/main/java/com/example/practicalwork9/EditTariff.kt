package com.example.practicalwork9

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_tariff.*

class EditTariff : AppCompatActivity() {

    // Добавляемый тариф
    private var tariff = Tariff()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_tariff)
        if (intent.extras?.get("tariffId") != null)
        {
            val id: Int = intent.extras?.get("tariffId").toString().toInt()
            tariff = tariffs.find { it.id == id }!!
            tariffName.text = SpannableStringBuilder(tariff.name)
            hdBroadcastSwitch.isChecked = tariff.hdBroadcast
            publicAccessSwitch.isChecked = tariff.publicAccess

        }
        else
        {
            finish()
        }
    }

    fun saveTariffButtonClick(view: View) {
        if (tariffName.text.toString() != "")
        {
            tariff.name = tariffName.text.toString()
            tariff.hdBroadcast = hdBroadcastSwitch.isChecked
            tariff.publicAccess = publicAccessSwitch.isChecked
            finish()
        }
        else
        {
            tariffName.text.clear()
        }
    }
}
