package com.example.shibarecyclerview.ui.main


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shibarecyclerview.data.models.ShibeResponse
import com.example.shibarecyclerview.data.repo.ShibeRepository
import com.example.shibarecyclerview.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var _shibes = MutableLiveData<Resource<List<String>>>()
    val shibes: LiveData<Resource<List<String>>> get() = _shibes

    init {
        getShibes()
    }

    private fun getShibes() {
        _shibes.value = Resource.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val shibeResource = ShibeRepository.getShibes(50)
            _shibes.postValue(shibeResource)
        }
    }
}