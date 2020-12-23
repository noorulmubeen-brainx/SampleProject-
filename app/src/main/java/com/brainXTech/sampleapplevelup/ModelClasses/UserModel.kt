package com.brainXTech.sampleapplevelup.ModelClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class User(
    var name: String,
    var id: Int,
    var uid: String,
    var email: String = "",
    @Json(name = "device_token")
    var deviceToken: String,
    @Json(name = "app_platform")
    var appPlatform: String,
    @Json(name = "app_version")
    var appVersion: String,
    @Json(name = "active?")
    var active: Boolean,
    @Json(name = "first_login?")
    var firstLogin: Boolean,
    @Json(name = "access_token")
    var accessToken: String? = null,
    @Json(name = "client")
    var client: String? = null
)