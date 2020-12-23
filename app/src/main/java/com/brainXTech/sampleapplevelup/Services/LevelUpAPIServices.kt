package com.brainXTech.sampleapplevelup.Services

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class LevelUpAPIServices {
    val BASE_URL:String="https://brainx-levelup.herokuapp.com/"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
}