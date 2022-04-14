package com.example.mimascota.models

import com.google.gson.annotations.SerializedName

data class UserAccessResult  (
    @SerializedName("code") var code:String = "",
    @SerializedName("message") var message:String = ""
)