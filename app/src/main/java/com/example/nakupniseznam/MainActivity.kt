package com.example.nakupniseznam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    lateinit var btnWrite:Button
    lateinit var btnRead:Button
    lateinit var btnClose:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRead=findViewById(R.id.btnRead)
        btnWrite=findViewById(R.id.btnWrite)
        btnClose=findViewById(R.id.btnClose)

        fun quitApp(view: View) {
            this@MainActivity.finish()
            exitProcess(0)
        }


        btnRead.setOnClickListener{
            val intent= Intent(this@MainActivity, Read::class.java)
            startActivity(intent)
        }

        btnWrite.setOnClickListener{
            val intent=Intent(this@MainActivity, Write::class.java)
            startActivity(intent)
        }

    }
}