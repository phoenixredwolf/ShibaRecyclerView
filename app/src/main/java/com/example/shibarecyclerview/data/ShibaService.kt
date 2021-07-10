package com.example.shibarecyclerview.data

import retrofit2.Response
import retrofit2.http.GET

interface ShibaService {

    @GET("/api/shibes?count=10&urls=false")
    suspend fun getShibaData(): Response<List<Shiba>>
}