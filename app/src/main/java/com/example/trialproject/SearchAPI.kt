package com.example.trialproject

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface SearchAPI {
    @get:GET("perusahaan")
    val perusahaanList: Observable<List<Perusahaan>>

    @POST("search")
    @FormUrlEncoded
    fun searchPerusahaan(@Field("search") searchQuery:String):Observable<List<Perusahaan>>
}