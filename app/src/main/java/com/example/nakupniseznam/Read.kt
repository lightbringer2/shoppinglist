package com.example.nakupniseznam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class Read : AppCompatActivity() {

    lateinit var rProgressBar: ProgressBar
    lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        recyclerView=findViewById(R.id.recyclerView)
        rProgressBar=findViewById(R.id.rProgressBar)

        val itList= arrayListOf<ShItem>()

        rProgressBar.visibility= View.GONE

        val queue=Volley.newRequestQueue(this)
        val url = "https://script.google.com/macros/s/AKfycbykpoCO2DXmVlrBPMeaBCsVVGUCf50UlhUD_SFLy_dHjDmSnqvCubv68bbEm8wg-eVk1g/exec"
        val jsonObjectRequest=object :JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener {

                val data=it.getJSONArray("items")
                for(i in 0 until data.length()){
                    val itmJasonObject=data.getJSONObject(i)
                    val itmObject=ShItem(
                        itmJasonObject.getString("Název"),
                        itmJasonObject.getInt("Počet"),
                        itmJasonObject.getString("Umístění"),
                        itmJasonObject.getInt("Předpokládaná_cena")
                    )
                    itList.add(itmObject)
                }
                //recyclerAdapter= ReadRecyclerAdapter(this,itList)
                //recyclerView.adapter=recyclerAdapter
                //recyclerView.layoutManager=layoutManager
            },Response.ErrorListener {
                Toast.makeText(this@Read, it.toString(), Toast.LENGTH_SHORT).show()
            }
        ){
            override fun getHeaders(): MutableMap<String, String> {
                return super.getHeaders()
            }
        }
        queue.add(jsonObjectRequest)

    }
}