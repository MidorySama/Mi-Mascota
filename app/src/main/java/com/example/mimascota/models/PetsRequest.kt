package com.example.mimascota.models

import com.google.gson.annotations.SerializedName

data class PetsRequest(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String = "",
    @SerializedName("Mascota") val mascota: String = "",
    @SerializedName("type") val type: String = "",
    @SerializedName("raza") val raza: String = "",
    @SerializedName("obs") val obs: String = "",
    @SerializedName("url_image") val url_image: String = ""
)



