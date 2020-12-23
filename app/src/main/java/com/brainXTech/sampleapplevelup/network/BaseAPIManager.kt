package com.brainXTech.sampleapplevelup.network

import com.brainXTech.sampleapplevelup.Utils.LevelUpApiUrl.BASE_URL
import com.brainXTech.sampleapplevelup.network.apiClient.LevelUpAPIClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object BaseAPIManager {
    private var baseRetrofit: Retrofit? = null

    fun getRetrofit():Retrofit{
        if(baseRetrofit!=null)
            return baseRetrofit!!
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()

    }


    fun getLevelUpRetrofit():LevelUpAPIClient{
        return getRetrofit().create(LevelUpAPIClient::class.java)
    }

}