package com.example.trialproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_deskripsi.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_layout_deskripsi.*
import kotlinx.android.synthetic.main.list_layout_perusahaan.*
import kotlinx.android.synthetic.main.list_layout_perusahaan.textViewPerusahaan
import org.json.JSONObject

class Deskripsi : AppCompatActivity() {

    lateinit var i: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deskripsi)

        val context = this

        back.setOnClickListener{

            val intent = Intent(context,ListPerusahaanActivity::class.java)
            startActivity(intent)

        }

        i = intent

        if(i.hasExtra("id")){

            if(i.getStringExtra("id").equals("1")){
                getPerusahaan1()
            }else if(i.getStringExtra("id").equals("2")){
                getPerusahaan2()
            }else if(i.getStringExtra("id").equals("3")){
                getPerusahaan3()
            }else if(i.getStringExtra("id").equals("4")){
                getPerusahaan4()
            }else if(i.getStringExtra("id").equals("5")){
                getPerusahaan5()
            }else if(i.getStringExtra("id").equals("6")){
                getPerusahaan6()
            }else if(i.getStringExtra("id").equals("7")){
                getPerusahaan7()
            }else if(i.getStringExtra("id").equals("8")){
                getPerusahaan8()
            }else if(i.getStringExtra("id").equals("9")){
                getPerusahaan9()
            }else if(i.getStringExtra("id").equals("10")){
                getPerusahaan10()
            }else if(i.getStringExtra("id").equals("11")){
                getPerusahaan11()
            }else if(i.getStringExtra("id").equals("12")){
                getPerusahaan12()
            }else if(i.getStringExtra("id").equals("13")){
                getPerusahaan13()
            }else if(i.getStringExtra("id").equals("14")){
                getPerusahaan14()
            }else if(i.getStringExtra("id").equals("15")){
                getPerusahaan15()
            }

        }

    }

    fun getPerusahaan1(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan1)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan2(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan3(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan4(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan4)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan5(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan5)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan6(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan6)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan7(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan7)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan8(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan8)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan9(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan9)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan10(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan10)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan11(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan11)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan12(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan12)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan13(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan13)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan14(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan14)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun getPerusahaan15(){

        val recyclerView = findViewById(R.id.recyclerViewDeskripsi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val perusahaanlist=ArrayList<Perusahaan>()

        AndroidNetworking.get(ApiEndPoint.perusahaan15)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))

                        var isi1=jsonObject.optString("id")
                        var isi2=jsonObject.optString("nama_perusahaan")
                        var isi3=jsonObject.optString("nama_sektor")
                        var isi4=jsonObject.optString("sektor_id")
                        var isi5=jsonObject.optString("pekerjaan")
                        var isi6=jsonObject.optString("lokasi")
                        var isi7=jsonObject.optString("gaji")
                        var isi8=jsonObject.optString("deskripsi")
                        var isi9=jsonObject.optString("syarat")
                        var isi10=jsonObject.optString("no_hp")
                        var isi11=jsonObject.optString("website")

                        perusahaanlist.add(
                            Perusahaan(
                                "$isi1",
                                "$isi2",
                                "$isi3",
                                "$isi4",
                                "$isi5",
                                "$isi6",
                                "$isi7",
                                "$isi8",
                                "$isi9",
                                "$isi10",
                                "$isi11"
                            )
                        )
                    }

                    val adapter=CustomAdapterDeskripsi(applicationContext,perusahaanlist)
                    recyclerView.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

}
