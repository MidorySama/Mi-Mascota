package com.example.mimascota.mapping

import com.example.mimascota.models.AccessResponse
import com.example.mimascota.models.AccessResultModel

internal fun AccessResponse.toModel(): AccessResultModel = AccessResultModel(
    code = requestUserRegister.code, message = requestUserRegister.message,
)





