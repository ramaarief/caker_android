package com.example.trialproject

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_list_perusahaan.*
import org.json.JSONObject

class ListPerusahaanActivity : AppCompatActivity() {

    var arrayList = ArrayList<Perusahaan>()
    lateinit var i: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_perusahaan)

        val context = this

        supportActionBar?.title = "Data Mahasiswa"

        recyclerViewPerusahaan.setHasFixedSize(true)
        recyclerViewPerusahaan.layoutManager = LinearLayoutManager(this)

        val search = findViewById(R.id.search) as SearchView

        val recyclerView2 = findViewById(R.id.recyclerViewSektor) as RecyclerView
        recyclerView2.layoutManager= LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        val sektorlist=ArrayList<Sektor>()

        AndroidNetworking.get("http://192.168.1.6/sektor/sektor_json.php")
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
                        var isi1=jsonObject.optString("id_sektor").toString()
                        var isi2=jsonObject.optString("nama_sektor").toString()

                        sektorlist.add(Sektor("$isi1", "$isi2"))


                    }

                    val adapter=CustomAdapterSektor(applicationContext,sektorlist)
                    recyclerView2.adapter=adapter


                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    override fun onResume() {
        super.onResume()
        loadAllPerusahaan()

        i = intent

        if(i.hasExtra("id_sektor")){

            if(i.getStringExtra("id_sektor").equals("1")){
                loadAllsektor()
            }else if(i.getStringExtra("id_sektor").equals("2")){
                loadSektor1()
            }else if(i.getStringExtra("id_sektor").equals("3")){
                loadSektor2()
            }else if(i.getStringExtra("id_sektor").equals("4")){
                loadSektor3()
            }else if(i.getStringExtra("id_sektor").equals("5")){
                loadSektor4()
            }else if(i.getStringExtra("id_sektor").equals("6")){
                loadSektor5()
            }else if(i.getStringExtra("id_sektor").equals("7")){
                loadSektor6()
            }

        }
    }


    private fun loadAllPerusahaan(){

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.READ)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{

                override fun onResponse(response: JSONObject?) {

                    arrayList.clear()

                    val jsonArray = response?.optJSONArray("result")

                    if(jsonArray?.length() == 0){
                        loading.dismiss()
                        Toast.makeText(applicationContext,"Student data is empty, Add the data first",
                            Toast.LENGTH_SHORT).show()
                    }

                    for(i in 0 until jsonArray?.length()!!){

                        val jsonObject = jsonArray?.optJSONObject(i)
                        arrayList.add(Perusahaan(jsonObject.getString("id"),
                            jsonObject.getString("nama_perusahaan"),
                            jsonObject.getString("nama_sektor"),
                            jsonObject.getString("sektor_id"),
                            jsonObject.getString("pekerjaan"),
                            jsonObject.getString("lokasi"),
                            jsonObject.getString("gaji"),
                            jsonObject.getString("deskripsi"),
                            jsonObject.getString("syarat"),
                            jsonObject.getString("no_hp"),
                            jsonObject.getString("website")))

                        if(jsonArray?.length() - 1 == i){

                            loading.dismiss()
                            val adapter = CustomAdapterPerusahaan(applicationContext,arrayList)
                            adapter.notifyDataSetChanged()
                            recyclerViewPerusahaan.adapter = adapter

                        }

                    }

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })


    }

    fun loadAllsektor(){

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.sektor1)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{

                override fun onResponse(response: JSONObject?) {

                    arrayList.clear()

                    val jsonArray = response?.optJSONArray("result")

                    if(jsonArray?.length() == 0){
                        loading.dismiss()
                        Toast.makeText(applicationContext,"Student data is empty, Add the data first",
                            Toast.LENGTH_SHORT).show()
                    }

                    for(i in 0 until jsonArray?.length()!!){

                        val jsonObject = jsonArray?.optJSONObject(i)
                        arrayList.add(Perusahaan(jsonObject.getString("id"),
                            jsonObject.getString("nama_perusahaan"),
                            jsonObject.getString("nama_sektor"),
                            jsonObject.getString("sektor_id"),
                            jsonObject.getString("pekerjaan"),
                            jsonObject.getString("lokasi"),
                            jsonObject.getString("gaji"),
                            jsonObject.getString("deskripsi"),
                            jsonObject.getString("syarat"),
                            jsonObject.getString("no_hp"),
                            jsonObject.getString("website")))

                        if(jsonArray?.length() - 1 == i){

                            loading.dismiss()
                            val adapter = CustomAdapterPerusahaan(applicationContext,arrayList)
                            adapter.notifyDataSetChanged()
                            recyclerViewPerusahaan.adapter = adapter

                        }

                    }

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })


    }

    fun loadSektor1(){

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.sektor2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{

                override fun onResponse(response: JSONObject?) {

                    arrayList.clear()

                    val jsonArray = response?.optJSONArray("result")

                    if(jsonArray?.length() == 0){
                        loading.dismiss()
                        Toast.makeText(applicationContext,"Student data is empty, Add the data first",
                            Toast.LENGTH_SHORT).show()
                    }

                    for(i in 0 until jsonArray?.length()!!){

                        val jsonObject = jsonArray?.optJSONObject(i)
                        arrayList.add(Perusahaan(jsonObject.getString("id"),
                            jsonObject.getString("nama_perusahaan"),
                            jsonObject.getString("nama_sektor"),
                            jsonObject.getString("sektor_id"),
                            jsonObject.getString("pekerjaan"),
                            jsonObject.getString("lokasi"),
                            jsonObject.getString("gaji"),
                            jsonObject.getString("deskripsi"),
                            jsonObject.getString("syarat"),
                            jsonObject.getString("no_hp"),
                            jsonObject.getString("website")))

                        if(jsonArray?.length() - 1 == i){

                            loading.dismiss()
                            val adapter = CustomAdapterPerusahaan(applicationContext,arrayList)
                            adapter.notifyDataSetChanged()
                            recyclerViewPerusahaan.adapter = adapter

                        }

                    }

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })


    }

    fun loadSektor2(){

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.sektor3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{

                override fun onResponse(response: JSONObject?) {

                    arrayList.clear()

                    val jsonArray = response?.optJSONArray("result")

                    if(jsonArray?.length() == 0){
                        loading.dismiss()
                        Toast.makeText(applicationContext,"Student data is empty, Add the data first",
                            Toast.LENGTH_SHORT).show()
                    }

                    for(i in 0 until jsonArray?.length()!!){

                        val jsonObject = jsonArray?.optJSONObject(i)
                        arrayList.add(Perusahaan(jsonObject.getString("id"),
                            jsonObject.getString("nama_perusahaan"),
                            jsonObject.getString("nama_sektor"),
                            jsonObject.getString("sektor_id"),
                            jsonObject.getString("pekerjaan"),
                            jsonObject.getString("lokasi"),
                            jsonObject.getString("gaji"),
                            jsonObject.getString("deskripsi"),
                            jsonObject.getString("syarat"),
                            jsonObject.getString("no_hp"),
                            jsonObject.getString("website")))

                        if(jsonArray?.length() - 1 == i){

                            loading.dismiss()
                            val adapter = CustomAdapterPerusahaan(applicationContext,arrayList)
                            adapter.notifyDataSetChanged()
                            recyclerViewPerusahaan.adapter = adapter

                        }

                    }

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })


    }

    fun loadSektor3(){

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.sektor4)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{

                override fun onResponse(response: JSONObject?) {

                    arrayList.clear()

                    val jsonArray = response?.optJSONArray("result")

                    if(jsonArray?.length() == 0){
                        loading.dismiss()
                        Toast.makeText(applicationContext,"Student data is empty, Add the data first",
                            Toast.LENGTH_SHORT).show()
                    }

                    for(i in 0 until jsonArray?.length()!!){

                        val jsonObject = jsonArray?.optJSONObject(i)
                        arrayList.add(Perusahaan(jsonObject.getString("id"),
                            jsonObject.getString("nama_perusahaan"),
                            jsonObject.getString("nama_sektor"),
                            jsonObject.getString("sektor_id"),
                            jsonObject.getString("pekerjaan"),
                            jsonObject.getString("lokasi"),
                            jsonObject.getString("gaji"),
                            jsonObject.getString("deskripsi"),
                            jsonObject.getString("syarat"),
                            jsonObject.getString("no_hp"),
                            jsonObject.getString("website")))

                        if(jsonArray?.length() - 1 == i){

                            loading.dismiss()
                            val adapter = CustomAdapterPerusahaan(applicationContext,arrayList)
                            adapter.notifyDataSetChanged()
                            recyclerViewPerusahaan.adapter = adapter

                        }

                    }

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })


    }

    fun loadSektor4(){

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.sektor5)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{

                override fun onResponse(response: JSONObject?) {

                    arrayList.clear()

                    val jsonArray = response?.optJSONArray("result")

                    if(jsonArray?.length() == 0){
                        loading.dismiss()
                        Toast.makeText(applicationContext,"Student data is empty, Add the data first",
                            Toast.LENGTH_SHORT).show()
                    }

                    for(i in 0 until jsonArray?.length()!!){

                        val jsonObject = jsonArray?.optJSONObject(i)
                        arrayList.add(Perusahaan(jsonObject.getString("id"),
                            jsonObject.getString("nama_perusahaan"),
                            jsonObject.getString("nama_sektor"),
                            jsonObject.getString("sektor_id"),
                            jsonObject.getString("pekerjaan"),
                            jsonObject.getString("lokasi"),
                            jsonObject.getString("gaji"),
                            jsonObject.getString("deskripsi"),
                            jsonObject.getString("syarat"),
                            jsonObject.getString("no_hp"),
                            jsonObject.getString("website")))

                        if(jsonArray?.length() - 1 == i){

                            loading.dismiss()
                            val adapter = CustomAdapterPerusahaan(applicationContext,arrayList)
                            adapter.notifyDataSetChanged()
                            recyclerViewPerusahaan.adapter = adapter

                        }

                    }

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })


    }

    fun loadSektor5(){

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.sektor6)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{

                override fun onResponse(response: JSONObject?) {

                    arrayList.clear()

                    val jsonArray = response?.optJSONArray("result")

                    if(jsonArray?.length() == 0){
                        loading.dismiss()
                        Toast.makeText(applicationContext,"Student data is empty, Add the data first",
                            Toast.LENGTH_SHORT).show()
                    }

                    for(i in 0 until jsonArray?.length()!!){

                        val jsonObject = jsonArray?.optJSONObject(i)
                        arrayList.add(Perusahaan(jsonObject.getString("id"),
                            jsonObject.getString("nama_perusahaan"),
                            jsonObject.getString("nama_sektor"),
                            jsonObject.getString("sektor_id"),
                            jsonObject.getString("pekerjaan"),
                            jsonObject.getString("lokasi"),
                            jsonObject.getString("gaji"),
                            jsonObject.getString("deskripsi"),
                            jsonObject.getString("syarat"),
                            jsonObject.getString("no_hp"),
                            jsonObject.getString("website")))

                        if(jsonArray?.length() - 1 == i){

                            loading.dismiss()
                            val adapter = CustomAdapterPerusahaan(applicationContext,arrayList)
                            adapter.notifyDataSetChanged()
                            recyclerViewPerusahaan.adapter = adapter

                        }

                    }

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })


    }

    fun loadSektor6(){

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.get(ApiEndPoint.sektor7)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{

                override fun onResponse(response: JSONObject?) {

                    arrayList.clear()

                    val jsonArray = response?.optJSONArray("result")

                    if(jsonArray?.length() == 0){
                        loading.dismiss()
                        Toast.makeText(applicationContext,"Student data is empty, Add the data first",
                            Toast.LENGTH_SHORT).show()
                    }

                    for(i in 0 until jsonArray?.length()!!){

                        val jsonObject = jsonArray?.optJSONObject(i)
                        arrayList.add(Perusahaan(jsonObject.getString("id"),
                            jsonObject.getString("nama_perusahaan"),
                            jsonObject.getString("nama_sektor"),
                            jsonObject.getString("sektor_id"),
                            jsonObject.getString("pekerjaan"),
                            jsonObject.getString("lokasi"),
                            jsonObject.getString("gaji"),
                            jsonObject.getString("deskripsi"),
                            jsonObject.getString("syarat"),
                            jsonObject.getString("no_hp"),
                            jsonObject.getString("website")))

                        if(jsonArray?.length() - 1 == i){

                            loading.dismiss()
                            val adapter = CustomAdapterPerusahaan(applicationContext,arrayList)
                            adapter.notifyDataSetChanged()
                            recyclerViewPerusahaan.adapter = adapter

                        }

                    }

                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })


    }
}
