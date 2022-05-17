package com.example.mimascota.models

import com.example.mimascota.activities.login.UserLogin
import com.google.gson.annotations.SerializedName

data class UserRegisterResult(
    @SerializedName("code") var code: String = "",
    @SerializedName("message") var message: String = "",
    @SerializedName("user") var user: UserLogin = UserLogin()
)
