package com.example.mimascota.repositories

import com.example.mimascota.api.CoreHomeApi
import javax.inject.Inject

class UserAccessRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {

   /* fun postAccess(): Single<MutableList<AllPets>> {
        return apiService.userAccess()
            .map { allPets ->
                allPets.toModel()
            }
    }*/

   /* fun userAccess(email: String, password: String): Single<AccesResultModel> {
        return apiService.userAccess(
            UserAccesRequest(
                email = email,
                password = password
            )
        )
            .map { UserAccesResponce ->
                UserAccesResponce.toModel()
            }
    }*/
}
