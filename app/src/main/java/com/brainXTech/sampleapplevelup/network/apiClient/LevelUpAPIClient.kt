package com.brainXTech.sampleapplevelup.network.apiClient

import com.brainXTech.sampleapplevelup.ModelClasses.User
import com.brainXTech.sampleapplevelup.Utils.LevelUpApiUrl
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.POST

interface LevelUpAPIClient {
    @POST(LevelUpApiUrl.SIGN_IN)
    fun signInUser(@Body body: Map<String, @JvmSuppressWildcards Any?>): Call<User>

    @POST(LevelUpApiUrl.FIRST_TIME_CHANGE_PASSWORD)
    fun changeUserPassword(
        @Header("access-token") token: String,
        @Header("uid") uId: String,
        @Header("client") client: String
    ): Call<Map<String, @JvmSuppressWildcards Any?>>

    @DELETE(LevelUpApiUrl.SIGN_OUT)
    fun signOutUser(
        @Header("access-token") token: String,
        @Header("uid") uId: String,
        @Header("client") client: String
    ): Call<Map<String, @JvmSuppressWildcards Any?>>


}