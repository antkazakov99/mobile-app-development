package com.example.practicalwork9

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import kotlinx.android.synthetic.main.activity_add_tariff.*


class AddTariff : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1

    // Добавляемый тариф
    private val newTariff: Tariff = Tariff()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_tariff)
        button2.setOnClickListener { addImageClick(imageView) }
        if (tariffs.size > 0)
        {
            tariffs.sortBy { it.id }
            newTariff.id = tariffs.last().id + 1
        }
        else
        {
            newTariff.id = 1
        }
    }

    fun addTariffButtonClick(view: View) {
        if (newTariffName.text.toString() != "")
        {
            newTariff.name = newTariffName.text.toString()
            newTariff.hdBroadcast = hdBroadcastSwitch.isChecked
            newTariff.publicAccess = publicAccessSwitch.isChecked
            newTariff.image = imageView.drawable.toBitmap()
            tariffs.add(newTariff)
            finish()
        }
        else
        {
            newTariffName.text.clear()
        }
    }

    private fun addImageClick(view: View) {
        dispatchTakePictureIntent()
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }

}
