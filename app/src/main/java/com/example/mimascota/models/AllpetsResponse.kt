package com.example.mimascota.models

import com.google.gson.annotations.SerializedName

class AllpetsResponse {

    @SerializedName("list_pets")
    val listAllPets: MutableList<PetsRequest> = mutableListOf()
}
