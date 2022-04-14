package com.example.mimascota.mapping

import com.example.mimascota.models.AccesResultModel
import com.example.mimascota.models.UserRegisterResponse

internal fun UserRegisterResponse.toModel(): AccesResultModel =
    AccesResultModel(
    code = responseCode,
    message = responseMessage,
)
