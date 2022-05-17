package com.example.mimascota.api


import com.example.mimascota.mapping.AllpetsResponse
import com.example.mimascota.models.UserAccessResponse
import com.example.mimascota.models.*
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CoreHomeApi {

    @GET("/pets")
    @Headers("Content-Type: application/json ")
    fun getAllPets(): Single<AllpetsResponse>

    @POST("/register_user_pet")
    @Headers("Content-Type: application/json")
    fun useRegister(@Body userRegister: UserAccessResponse): Single<UserRegisterResult>

    @POST("/access_pet")
    @Headers("Content-Type: application/json ")
    fun userAccess(@Body userRequest: UserAccessRequest): Single<UserRegisterResult>
}
