package com.example.mimascota.models

import com.google.gson.annotations.SerializedName

data class AccessResponce(
    @SerializedName("result")
    val requestUserAccess: UserAccessResult = UserAccessResult()
)
