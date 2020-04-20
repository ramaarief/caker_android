package com.example.trialproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_list_perusahaan.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class ListPerusahaanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_perusahaan)

        val search = findViewById(R.id.search) as SearchView

        val recyclerView1 = findViewById(R.id.recyclerViewPerusahaan) as RecyclerView
        recyclerView1.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val context = this

        search.setOnClickListener{

            val intent = Intent(context,Deskripsi::class.java)
            startActivity(intent)

        }

        val recyclerView2 = findViewById(R.id.recyclerViewSektor) as RecyclerView
        recyclerView2.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        val perusahaan=ArrayList<Perusahaan>()
        val sektor=ArrayList<Sektor>()

        AndroidNetworking.get("http://192.168.1.3/sektor/perusahaan_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        // txt1.setText(jsonObject.optString("shubuh"))
                        var isi1=jsonObject.optString("nama_perusahaan").toString()
                        var isi2=jsonObject.optString("pekerjaan").toString()
                        var isi3=jsonObject.optString("lokasi").toString()
                        var isi4=jsonObject.optString("gaji").toString()
                        var isi5=jsonObject.optString("deskripsi").toString()
                        var isi6=jsonObject.optString("syarat").toString()
                        var isi7=jsonObject.optString("no_hp").toString()
                        var isi8=jsonObject.optString("website").toString()

                        perusahaan.add(Perusahaan("$isi1", "$isi2", "$isi3", "$isi4", "$isi5", "$isi6", "$isi7", "$isi8"))


                    }

                    val adapter=CustomAdapterPerusahaan(perusahaan)
                    recyclerView1.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })

        AndroidNetworking.get("http://192.168.1.3/sektor/sektor_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id_sektor"))

                        // txt1.setText(jsonObject.optString("shubuh"))
                        var isi1=jsonObject.optString("nama_sektor").toString()

                        sektor.add(Sektor("$isi1"))


                    }

                    val adapter=CustomAdapterSektor(sektor)
                    recyclerView2.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

}
