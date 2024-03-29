package com.example.nakupniseznam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import androidx.annotation.NonNull

internal class ItemAdapter(private  var itemsList: List<String>):
        RecyclerView.Adapter<ItemAdapter.MyViewHolder>(){
            internal  inner class  MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
                var itemTextView: TextView = view.findViewById(R.id.itemTextView)
            }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}