package com.tests.weatheredu.data.repositories

import com.tests.weatheredu.data.models.GetWeatherResponse
import com.tests.weatheredu.data.remote_db.RetrofitHelper
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(){


    suspend fun getWeatherByCity(
        city: String
    ): Response<GetWeatherResponse> {
        return RetrofitHelper.api.getWeatherByCity(city)
    }

}