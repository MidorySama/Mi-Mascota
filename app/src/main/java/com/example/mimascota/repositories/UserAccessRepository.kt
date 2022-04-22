package com.example.mimascota.repositories

import com.example.mimascota.api.CoreHomeApi
import com.example.mimascota.mapping.toModel
import com.example.mimascota.models.*
import io.reactivex.Single
import javax.inject.Inject

class UserAccessRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {

    fun postAccess(): Single<MutableList<AllPets>> {
        return apiService.getUserAccess()
            .map { allPets ->
                allPets.toModel()
            }
    }

    fun userAccess(email: String, password: String): Single<AccessResultModel> {
        return apiService.userAccess(
            UserAccesRequest(
                email = email,
                password = password
            )
        )
            .map { accessResultModel ->
                accessResultModel.toModel()
            }
    }
}
