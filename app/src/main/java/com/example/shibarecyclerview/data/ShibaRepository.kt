package com.example.shibarecyclerview.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.shibarecyclerview.LOG_TAG
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class ShibaRepository(val app: Application) {

    val shibaData = MutableLiveData<List<Shiba>>()

    private val listType = Types.newParameterizedType(
        List::class.java, Shiba::class.java
    )

    init {
        getShibaData()
        Log.i(LOG_TAG, "Network available: ${networkAvailable()}")
    }

    fun getShibaData() {
        val text: String
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<Shiba>> = moshi.adapter(listType)
        shibaData.value = adapter.fromJson(text) ?: emptyList()
    }

    @Suppress("DEPRECATION")
    private fun networkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false
    }
}