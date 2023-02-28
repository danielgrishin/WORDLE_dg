package com.example.wordledang1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play = findViewById<Button>(R.id.buttonMainPlay)

        play.setOnClickListener{
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }


    }
}