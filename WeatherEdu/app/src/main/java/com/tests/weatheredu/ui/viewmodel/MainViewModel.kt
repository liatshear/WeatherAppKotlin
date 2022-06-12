package com.tests.weatheredu.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tests.weatheredu.data.models.GetWeatherResponse
import com.tests.weatheredu.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var weatherResponse: MutableLiveData<Response<GetWeatherResponse>> = MutableLiveData()


    fun getWeather(city: String) {
        viewModelScope.launch {
            val response = repository.getWeatherByCity(city)
            weatherResponse.value = response
        }
    }



}