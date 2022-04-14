package com.example.mimascota.models

import com.google.gson.annotations.SerializedName

data class UserAccessResponce (
    @SerializedName ("email") var email: String = "",
    @SerializedName("password") var password: String = "" )