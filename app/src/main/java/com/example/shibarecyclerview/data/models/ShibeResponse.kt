package com.example.shibarecyclerview.data.models

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ShibeResponse(
    val urls: List<String>

)
