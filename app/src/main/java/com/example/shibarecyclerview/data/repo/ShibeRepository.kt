package com.example.shibarecyclerview.data.repo

import com.example.shibarecyclerview.data.remote.ShibeManager
import com.example.shibarecyclerview.util.Resource

object ShibeRepository {

    suspend fun getShibes(count: Int): Resource<List<String>> {
        return try {
            val shibesResponse = ShibeManager.getShibes(count)
            if (shibesResponse.isSuccessful && shibesResponse.body() != null) {
                Resource.Success(shibesResponse.body()!!)
            } else {
                Resource.Error(null, errorMsg = "No Shibes found")
            }
        } catch (ex: Exception) {
            Resource.Error(exception = ex, "Unexpected Error")
        }
    }
}