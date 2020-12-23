package com.brainXTech.sampleapplevelup.network.apiClient

import com.brainXTech.sampleapplevelup.ModelClasses.User
import com.brainXTech.sampleapplevelup.Utils.LevelUpApiUrl
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LevelUpAPIClient {
    @POST(LevelUpApiUrl.SIGN_IN)
    fun signInUser(@Body body: Map<String, @JvmSuppressWildcards Any?>): Call<User>
}