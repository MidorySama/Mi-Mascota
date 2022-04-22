package com.example.mimascota.mapping

import com.example.mimascota.models.AccessResultModel
import com.example.mimascota.models.UserRegisterResponse

internal fun UserRegisterResponse.toModel(): AccessResultModel =
    AccessResultModel(
        code = responseCode,
        message = responseMessage,
    )
