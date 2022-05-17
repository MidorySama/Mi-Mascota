package com.example.mimascota.activities.login

import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName("email") var email: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("last_name") var lastName: String = "",
    @SerializedName("password") var password: String = ""
)