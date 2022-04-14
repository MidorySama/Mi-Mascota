package com.example.mimascota.models

import com.google.gson.annotations.SerializedName

data class UserRegisterResponse (
    @SerializedName("code") val responseCode: String ="",
    @SerializedName("message") val responseMessage: String =""
)
