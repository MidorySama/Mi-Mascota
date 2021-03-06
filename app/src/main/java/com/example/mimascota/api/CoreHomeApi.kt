package com.example.mimascota.api

import com.example.mimascota.models.AccessResponce
import com.example.mimascota.models.UserAccesRequest
import com.example.mimascota.models.UserRegisterRequest
import com.example.mimascota.models.UserRegisterResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CoreHomeApi {

    @GET("/pets")
    @Headers("Content-Type: application/json ")
    fun getUserAccess(): Single<UserRegisterResponse>

    @POST("/register_user_pet")
    @Headers("Content-Type: application/json")
    fun userRegister(@Body userRegister: UserRegisterRequest): Single<UserRegisterResponse>

    @POST("/access_pet")
    @Headers("Content-Type: application/json ")
    fun userAccess(@Body userRequest: UserAccesRequest): Single<AccessResponce>
}
