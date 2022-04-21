package com.example.mimascota.repositories

import com.example.mimascota.api.CoreHomeApi
import com.example.mimascota.mapping.toModel
import com.example.mimascota.models.AccesResultModel
import com.example.mimascota.models.UserRegisterRequest
import io.reactivex.Single
import javax.inject.Inject

class UserRegisterRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {

    fun userRegister(email: String, name: String, lastName: String, password: String):
        Single<AccesResultModel> {
        return apiService.userRegister(
            userRegister = UserRegisterRequest(
                email = email,
                name = name,
                lastName = lastName,
                password = password
            )
        )
            .map { userRegister -> userRegister.toModel() }
    }
}
