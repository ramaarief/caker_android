package com.example.trialproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_layout_perusahaan.view.*

class CustomAdapterPerusahaan (private val context: Context, private val perusahaanList: List<Perusahaan>) : RecyclerView.Adapter<CustomAdapterPerusahaan.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_layout_perusahaan,parent,false))
    }

    override fun getItemCount(): Int = perusahaanList!!.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.view.textViewPerusahaan.text = perusahaanList?.get(position)?.nama_perusahaan
        holder.view.textViewPekerjaan.text = perusahaanList?.get(position)?.pekerjaan
        holder.view.textViewLokasi.text = perusahaanList?.get(position)?.lokasi
        holder.view.textViewGaji.text = perusahaanList?.get(position)?.gaji

        holder.view.cvList.setOnClickListener {

            val i = Intent(context,Deskripsi::class.java)
            i.putExtra("id",perusahaanList?.get(position)?.id)
            i.putExtra("nama_perusahaan",perusahaanList?.get(position)?.nama_perusahaan)
            i.putExtra("pekerjaan",perusahaanList?.get(position)?.pekerjaan)
            i.putExtra("lokasi",perusahaanList?.get(position)?.lokasi)
            i.putExtra("gaji",perusahaanList?.get(position)?.gaji)
            context.startActivity(i)

        }

    }

    class Holder(val view:View) : RecyclerView.ViewHolder(view)

}