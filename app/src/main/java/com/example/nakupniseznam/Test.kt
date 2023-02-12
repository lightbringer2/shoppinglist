package com.example.nakupniseznam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Test : AppCompatActivity() {

    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: ItemAdapter

    //val items: ArrayList<ShItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val recyclerView: RecyclerView = findViewById(R.id.rv_item_list)
        customAdapter = ItemAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()

        //addItems()

        //rv_item_list.layoutManager = LinearLayoutManager(this)

        //rv_item_list.layoutManager = GridLayoutManager(this, 2)

        //rv_item_list.adapter = ItemAdapter(items, this)

    }
    private fun prepareItems(){
        itemsList.add("Item 1")
        itemsList.add("Item 2")
        itemsList.add("Item 3")
        itemsList.add("Item 4")
        itemsList.add("Item 5")
        itemsList.add("Item 6")
        itemsList.add("Item 7")
        itemsList.add("Item 8")
        itemsList.add("Item 9")
        itemsList.add("Item 10")
        itemsList.add("Item 11")
        itemsList.add("Item 12")
    }

    fun addItems()
    {
        //items.add(ShItem("Tužka",2, "Kaufland", 1000))
        //items.add(ShItem("Guma",2, "Kaufland", 1001))
        //items.add(ShItem("Pero",2, "Kaufland", 1002))
    }

}