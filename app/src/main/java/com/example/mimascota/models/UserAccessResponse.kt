package com.example.mimascota.models

import com.google.gson.annotations.SerializedName

data class UserAccessResponse(
    @SerializedName("email") var email: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("last_name") var lastName: String = "",
    @SerializedName("password") var password: String = ""
)

