package com.tests.weatheredu.data.remote_db

import com.tests.weatheredu.data.models.GetWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("weather/{city}")
    suspend fun getWeatherByCity(
        @Path("city")city:String
    ): Response<GetWeatherResponse>
}