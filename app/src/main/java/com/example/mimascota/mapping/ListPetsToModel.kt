package com.example.mimascota.mapping

import AccessResult
import com.example.mimascota.models.ListAllPets

internal fun AccessResult.toModel(): MutableList<ListAllPets> {
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
