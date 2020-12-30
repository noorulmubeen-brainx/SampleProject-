package com.brainXTech.sampleapplevelup.Utils

object LevelUpApiUrl {
    const val BASE_URL="https://brainx-levelup.herokuapp.com/"
    private const val VERSION = "/api/v1"
    const val USERS = "$VERSION/users"
    const val USER = "$VERSION/user"
    const val SIGN_IN = "$USERS/sign_in.json"
    const val SIGN_OUT = "$USERS/sign_out.json"
    const val FIRST_TIME_CHANGE_PASSWORD = "$USER/change_password.json"




}