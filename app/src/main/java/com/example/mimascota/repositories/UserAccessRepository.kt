package com.example.mimascota.repositories

import com.example.mimascota.api.CoreHomeApi
import com.example.mimascota.models.AccesResultModel
import com.example.mimascota.models.AllPets
import com.example.mimascota.models.UserAccesRequest
import io.reactivex.Single
import javax.inject.Inject

class UserAccessRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {

    fun postAccess(): Single<MutableList<AllPets>> {
        return apiService.userAccess()
            .map { allPets ->
                allPets.toModel()
            }
    }

    fun userAccess(email: String, password: String): Single<AccesResultModel> {
        return apiService.userAccess(
            UserAccesRequest(
                email = email,
                password = password
            )
        )
            .map { UserAccesResponce ->
                UserAccesResponce.toModel()
            }
    }
}
