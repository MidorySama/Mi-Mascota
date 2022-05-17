package com.example.mimascota.mapping

import com.example.mimascota.models.UserRegisterResult
import com.google.gson.annotations.SerializedName

data class AccessResponse(
    @SerializedName("result")val requestUserRegister: UserRegisterResult = UserRegisterResult()

)
