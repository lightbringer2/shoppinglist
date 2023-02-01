package com.example.nakupniseznam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    lateinit var btnWrite:Button
    lateinit var btnRead:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRead=findViewById(R.id.btnRead)
        btnWrite=findViewById(R.id.btnWrite)

        btnRead.setOnClickListener{
            val intent= Intent(this@MainActivity, Write::class.java)
            startActivity(intent)
        }

        btnWrite.setOnClickListener{
            val intent=Intent(this@MainActivity, Read::class.java)
            startActivity(intent)
        }

    }
}