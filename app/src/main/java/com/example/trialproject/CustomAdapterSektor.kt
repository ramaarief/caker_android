package com.example.trialproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapterSektor (val sektorList: ArrayList<Sektor>): RecyclerView.Adapter<CustomAdapterSektor.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val sektor: Sektor=sektorList[position]
        holder?.textViewSektor?.text = sektor.nama_sektor

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.list_layout_sektor, parent, false)
        return  ViewHolder(v)

    }

    override fun getItemCount(): Int {

        return sektorList.size
    }

    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textViewSektor = itemView.findViewById(R.id.textViewSektor) as TextView

    }

}