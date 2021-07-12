package com.example.shibarecyclerview.data.remote

import com.example.shibarecyclerview.data.models.ShibeResponse
import retrofit2.Response

object ShibeManager {

    private val service: ShibeService
    private val retrofit = RetrofitService.providesRetrofitService()

    init {
        service = retrofit.create(ShibeService::class.java)
    }

    suspend fun getShibes(count: Int = 100): Response<List<String>> {
        return service.getShibes(count)
    }
}