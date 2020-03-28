package com.example.practicalwork9

import android.content.Intent
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_tariff.*
import kotlinx.android.synthetic.main.activity_show_tariffs.*

class ShowTariffs : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_tariffs)
        searchButton.setOnClickListener { searchClick(searchButton) }
        val spinner: Spinner = findViewById(R.id.spinner)

        updateList()
    }

    private fun updateList()
    {
        testview.removeAllViews()
        when (spinner.selectedItemPosition)
        {
            0 -> tariffs.sortBy { it.id }
            1 -> tariffs.sortBy { it.name }
            2 -> tariffs.sortBy { it.hdBroadcast }
            3 -> tariffs.sortBy { it.publicAccess }
        }
        tariffs.filter { it.name.contains(searchText.text.toString()) }.forEach {
            val item: LinearLayout = LinearLayout(this)
            item.orientation = LinearLayout.VERTICAL
            testview.addView(item)

            val tariffName: TextView = TextView(this)
            tariffName.text = "${it.name}"
            tariffName.textSize = 20F
            item.addView(tariffName)

            val tariffImage: ImageView = ImageView(this)
            tariffImage.setImageBitmap(it.image)
            item.addView(tariffImage)

            val tariffFlags: TextView = TextView(this)
            tariffFlags.text = "HD: ${it.hdBroadcast}, Public: ${it.publicAccess}"
            item.addView(tariffFlags)

            val deleteButton: Button = Button(this)
            deleteButton.setOnClickListener { deleteTariff(deleteButton) }
            deleteButton.tag = it.id
            deleteButton.text = "Delete"
            item.addView(deleteButton)

            val editButton: Button = Button(this)
            editButton.setOnClickListener { editTariff(editButton) }
            editButton.tag = it.id
            editButton.text = "Edit"
            item.addView(editButton)

        }
    }

    private fun deleteTariff(view: View) {
        tariffs.removeAll { it.id == view.tag }
        updateList()
    }

    private fun editTariff(view: View) {
        val intent = Intent(this, EditTariff::class.java)
        val test: TextView = TextView(this)
        intent.putExtra("tariffId", view.tag.toString())
        startActivity(intent)
    }

    private fun searchClick(view: View) {
        updateList()
    }

}
