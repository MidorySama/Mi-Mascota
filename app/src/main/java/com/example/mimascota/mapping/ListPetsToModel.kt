package com.example.mimascota.mapping

import ManyAccessResult
import com.example.mimascota.models.ListAllPets

internal fun ManyAccessResult.toModel(): MutableList<ListAllPets> {
    val listAllList: MutableList<ListAllPets> = mutableListOf()

    requestUserAccess.map { list ->
        requestUserAccess.add(
            ListAllPets(
                id = list.id,
                name = list.name,
                type = list.type,
                raza = list.raza,
                obs = list.obs,
                url_image = list.url_image,
            )
        )
    }

    return listAllList
}
