package com.example.fpandroid

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Film>("DATA")
        Log.d("Detail Data", data?.name.toString())

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvDescription: TextView = findViewById(R.id.tv_description)
        val ivPhoto: ImageView = findViewById(R.id.iv_photo)
        val tvProducer: TextView = findViewById(R.id.tv_producer)
        val tvActor: TextView = findViewById(R.id.tv_actor)
        val tvYear: TextView = findViewById(R.id.tv_year)


        data?.let {
            tvName.text = it.name
            tvDescription.text = it.description
            ivPhoto.setImageResource(it.photo)
            tvProducer.text = "Producer: ${it.producer}"
            tvActor.text = "Actor: ${it.actor}"
            tvYear.text = "Year: ${it.year}"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
