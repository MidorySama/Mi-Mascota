package com.example.mimascota.mapping

import com.example.mimascota.models.AccessResultModel

class UserAccesResult(
    var susses: Boolean = false,
    var list: MutableList <AccessResultModel> = mutableListOf()
)
