package com.example.trialproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapterPerusahaan (val perusahaanList: ArrayList<Perusahaan>): RecyclerView.Adapter<CustomAdapterPerusahaan.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pekerjaan: Perusahaan=perusahaanList[position]
        holder?.textViewNama?.text = pekerjaan.nama_perusahaan
        holder?.textViewPekerjaan?.text = pekerjaan.pekerjaan
        holder?.textViewLokasi?.text = pekerjaan.lokasi
        holder?.textViewGaji?.text = pekerjaan.gaji

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.list_layout_perusahaan, parent, false)
        return  ViewHolder(v)

    }

    override fun getItemCount(): Int {

        return perusahaanList.size
    }

    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textViewNama = itemView.findViewById(R.id.textViewNama) as TextView
        val textViewPekerjaan = itemView.findViewById(R.id.textViewPekerjaan) as TextView
        val textViewLokasi = itemView.findViewById(R.id.textViewLokasi) as TextView
        val textViewGaji = itemView.findViewById(R.id.textViewGaji) as TextView

    }

}