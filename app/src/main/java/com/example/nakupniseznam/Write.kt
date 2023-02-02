package com.example.nakupniseznam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Write : AppCompatActivity() {

    lateinit var wProcessLayout:RelativeLayout
    lateinit var wProgressBar:ProgressBar
    lateinit var edName:EditText
    lateinit var edNum:EditText
    lateinit var edLoc:EditText
    lateinit var edPrice:EditText
    lateinit var btnSave:Button
    lateinit var btnClose:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        wProcessLayout=findViewById(R.id.wProcessLayout)
        wProgressBar=findViewById(R.id.wProgressBar)
        edName=findViewById(R.id.edName)
        edNum=findViewById(R.id.edNum)
        edLoc=findViewById(R.id.edLoc)
        edPrice=findViewById(R.id.edPrice)
        btnSave=findViewById(R.id.btnSave)
        btnClose=findViewById(R.id.btnClose)

        wProcessLayout.visibility=View.GONE
        wProgressBar.visibility=View.GONE

        btnClose.setOnClickListener{
            val intent= Intent(this@Write, MainActivity::class.java)
            startActivity(intent)
        }

        btnSave.setOnClickListener {
            if (edName.text.toString().isEmpty()){
                Toast.makeText(this@Write, "Není zadán název.", Toast.LENGTH_SHORT).show()
            }
            else {
                val url = "https://script.google.com/macros/s/AKfycbykpoCO2DXmVlrBPMeaBCsVVGUCf50UlhUD_SFLy_dHjDmSnqvCubv68bbEm8wg-eVk1g/exec"
                val stringRequest = object : StringRequest(Request.Method.POST, url,
                    Response.Listener {
                        Toast.makeText(this@Write, it.toString(), Toast.LENGTH_SHORT).show()
                    },
                    Response.ErrorListener {
                        Toast.makeText(this@Write, it.toString(), Toast.LENGTH_SHORT).show()
                    }){
                    override fun getParams(): MutableMap<String, String>? {
                        val params=HashMap<String, String>()
                        params["Název"]=edName.text.toString()

                        if(edNum.text.toString().isEmpty()){
                            params["Počet"] = "1"
                        }
                        else {
                            params["Počet"] = edNum.text.toString()
                        }
                        if(edLoc.text.toString().isEmpty()){
                            params["Umístění"] = "nezadáno"
                        }
                        else {
                            params["Umístění"] = edLoc.text.toString()
                        }
                        if(edPrice.text.toString().isEmpty()){
                            params["Předpokládaná_cena"] = "0"
                        }
                        else {
                            params["Předpokládaná_cena"] = edPrice.text.toString()
                        }
                        return params
                    }
            }
                val queue= Volley.newRequestQueue(this@Write)
                queue.add(stringRequest)
            }
        }
    }
}