package com.example.trialproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_layout_sektor.view.*
import kotlinx.android.synthetic.main.list_layout_sektor.view.cvList

class CustomAdapterSektor (private val context: Context, private val sektorList: ArrayList<Sektor>): RecyclerView.Adapter<CustomAdapterSektor.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val sektor: Sektor=sektorList[position]
        holder?.textViewSektor?.text = sektor.nama_sektor
        holder.cvlist.setOnClickListener{
            val i = Intent(context,ListPerusahaanActivity::class.java)
            i.putExtra("id_sektor",sektorList?.get(position)?.id_sektor)
            i.putExtra("nama_sektor",sektorList?.get(position)?.nama_sektor)
            context.startActivity(i)
        }

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
        val cvlist = itemView.findViewById(R.id.cvList) as CardView

    }

}