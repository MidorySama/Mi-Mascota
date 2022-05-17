package com.example.mimascota.mapping

import com.example.mimascota.models.PetsRequest
import com.google.gson.annotations.SerializedName

class AllpetsResponse {

    @SerializedName("list_pets")
    val listAllPets: MutableList<PetsRequest> = mutableListOf()
}
