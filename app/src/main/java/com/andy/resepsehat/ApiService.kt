package com.andy.resepsehat

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("index.php/C_json/select_sehat")
    fun daftarResep(): Call<Response>
}