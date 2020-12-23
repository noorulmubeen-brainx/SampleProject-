package com.brainXTech.sampleapplevelup.network

import android.telecom.Call
import com.brainXTech.sampleapplevelup.ModelClasses.User
import com.brainXTech.sampleapplevelup.`interface`.IResponse
import retrofit2.Callback
import retrofit2.Response

object UserAPIConnection {
    fun signInUser(body:Map<String,Any?>,signInListener: IResponse<User, String>){
        val result=BaseAPIManager.getLevelUpRetrofit().signInUser(body)
        result.enqueue(object: Callback<User> {
            override fun onResponse(
                call: retrofit2.Call<User>,
                response: Response<User>
            ) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    apiResponse?.accessToken = response.headers().get("access-token")
                    apiResponse?.client = response.headers().get("client")
                    if (apiResponse != null)
                        signInListener.onSuccess(apiResponse)
                    else
                        signInListener.onFailure("Error While getting response")
                } else {
                    try {
                        signInListener.onFailure(
                            "Please try again.Invalid Credentials"
                        )
                    } catch (e: Exception) {
                        e.message?.let { signInListener.onFailure(it) }
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<User>, t: Throwable) {
                signInListener.onFailure("There was some error in server")
            }
        } )

    }

}