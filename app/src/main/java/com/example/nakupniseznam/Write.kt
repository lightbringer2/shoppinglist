package com.example.nakupniseznam

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

        wProcessLayout.visibility=View.GONE
        wProgressBar.visibility=View.GONE


        btnSave.setOnClickListener {
            if (edName.text.toString().isEmpty()){





            }
            else {
                val url = ""
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
                            params["Cena"] = "0"
                        }
                        else {
                            params["Cena"] = edPrice.text.toString()
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