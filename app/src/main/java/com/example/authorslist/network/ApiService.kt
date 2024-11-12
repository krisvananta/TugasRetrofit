package com.example.authorslist.network

import com.example.authorslist.model.Authors
import com.example.authorslist.model.DayOff
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api") // ini untuk memanggil api, sesuaikan dengan route nya
    fun getAllDayOff(): Call<List<DayOff>> // ini list karena data dari json nya bentuknya list

}