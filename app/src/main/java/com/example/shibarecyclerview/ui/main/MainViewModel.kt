package com.example.shibarecyclerview.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.shibarecyclerview.data.ShibaRepository

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val dataRepo = ShibaRepository(app)
    val shibaData = dataRepo.shibaData

}