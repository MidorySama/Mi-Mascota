package com.example.mimascota.mapping

import com.example.mimascota.models.AccessResultModel
import com.example.mimascota.models.UserRegisterResult

internal fun UserRegisterResult.toModel() = AccessResultModel(
    code = code, message = message
)





