package com.example.trialproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_layout_deskripsi.view.*
import kotlinx.android.synthetic.main.list_layout_perusahaan.view.*
import kotlinx.android.synthetic.main.list_layout_perusahaan.view.textViewPerusahaan

class CustomAdapterDeskripsi (private val context: Context, private val perusahaanList: ArrayList<Perusahaan>) : RecyclerView.Adapter<CustomAdapterDeskripsi.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val perusahaan: Perusahaan=perusahaanList[position]
        holder?.textViewPerusahaan?.text = perusahaan.nama_perusahaan
        holder?.textViewJob?.text = perusahaan.pekerjaan
        holder?.textViewLocation?.text = perusahaan.lokasi
        holder?.textViewSalary?.text = perusahaan.gaji
        holder?.textViewDeskripsi?.text = perusahaan.deskripsi
        holder?.textViewSyarat?.text = perusahaan.syarat
        holder?.textViewHp?.text = perusahaan.no_hp
        holder?.textViewWebsite?.text = perusahaan.website

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.list_layout_deskripsi, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {

        return perusahaanList.size
    }

    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textViewPerusahaan = itemView.findViewById(R.id.textViewPerusahaan) as TextView
        val textViewJob = itemView.findViewById(R.id.textViewJob) as TextView
        val textViewLocation = itemView.findViewById(R.id.textViewLocation) as TextView
        val textViewSalary = itemView.findViewById(R.id.textViewSalary) as TextView
        val textViewDeskripsi = itemView.findViewById(R.id.textViewDeskripsi) as TextView
        val textViewSyarat = itemView.findViewById(R.id.textViewSyarat) as TextView
        val textViewHp = itemView.findViewById(R.id.textViewHp) as TextView
        val textViewWebsite = itemView.findViewById(R.id.textViewWebsite) as TextView


    }

}