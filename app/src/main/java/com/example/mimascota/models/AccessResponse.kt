package com.example.mimascota.models

import com.google.gson.annotations.SerializedName

data class AccessResponse(
    @SerializedName("result")val requestUserRegister: UserRegisterResult = UserRegisterResult()

)
