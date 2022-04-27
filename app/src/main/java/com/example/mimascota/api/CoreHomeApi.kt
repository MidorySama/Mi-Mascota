package com.example.mimascota.api

import AccessResult
import com.example.mimascota.models.AccessResponse
import com.example.mimascota.models.UserAccesRequest
import com.example.mimascota.models.UserAccessResponse
import com.example.mimascota.models.UserRegisterResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CoreHomeApi {

    @GET("/pets")
    @Headers("Content-Type: application/json ")
    fun getUserAccess(): Single<AccessResult>

    @POST("/register_user_pet")
    @Headers("Content-Type: application/json")
    fun useRegister(@Body userRegister: UserAccessResponse): Single<UserRegisterResponse>

    @POST("/access_pet")
    @Headers("Content-Type: application/json ")
    fun userAccess(@Body userRequest: UserAccesRequest): Single<AccessResponse>
}
