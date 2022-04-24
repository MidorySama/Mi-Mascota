package com.example.mimascota.repositories

import com.example.mimascota.api.CoreHomeApi
import com.example.mimascota.mapping.toModel
import com.example.mimascota.models.AccessResultModel
import com.example.mimascota.models.UserAccesRequest
import io.reactivex.Single
import javax.inject.Inject

class UserAccessRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {

    fun userAccess(email: String, password: String): Single<AccessResultModel> {
        return apiService.userAccess(
            userRequest = UserAccesRequest(
                email = email,
                password = password
            )
        )
            .map { userAccessResponse ->
                userAccessResponse.toModel()
            }
    }
}
