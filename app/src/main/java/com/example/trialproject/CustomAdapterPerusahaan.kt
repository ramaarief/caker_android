package com.example.trialproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_layout_perusahaan.view.*

class CustomAdapterPerusahaan (private val context: Context, private val arrayList: ArrayList<Perusahaan>) : RecyclerView.Adapter<CustomAdapterPerusahaan.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_layout_perusahaan,parent,false))
    }

    override fun getItemCount(): Int = arrayList!!.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.view.textViewPerusahaan.text = arrayList?.get(position)?.nama_perusahaan
        holder.view.textViewPekerjaan.text = arrayList?.get(position)?.pekerjaan
        holder.view.textViewLokasi.text = arrayList?.get(position)?.lokasi
        holder.view.textViewGaji.text = arrayList?.get(position)?.gaji

        holder.view.cvList.setOnClickListener {

            val i = Intent(context,Deskripsi::class.java)
            i.putExtra("id",arrayList?.get(position)?.id)
            i.putExtra("nama_perusahaan",arrayList?.get(position)?.nama_perusahaan)
            i.putExtra("pekerjaan",arrayList?.get(position)?.pekerjaan)
            i.putExtra("lokasi",arrayList?.get(position)?.lokasi)
            i.putExtra("gaji",arrayList?.get(position)?.gaji)
            context.startActivity(i)

        }

    }

    class Holder(val view:View) : RecyclerView.ViewHolder(view)

}