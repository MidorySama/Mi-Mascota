package com.example.mimascota.mapping

import com.example.mimascota.models.AccessResponse
import com.example.mimascota.models.AllPets

internal fun AccessResponse.toModel(): MutableList<AllPets> {
    val allList: MutableList<AllPets> = mutableListOf()

    allList.map { list ->
        allList.add(
            AllPets(
                id = list.id,
                name = list.name,
                type = list.type,
                raza = list.raza,
                obs = list.obs,
                url_image = list.url_image,
            )
        )
    }

    return allList
}
