package com.example.mimascota.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class AllPets(
    var id: String = "",
    var name: String = "",
    var type: String = "",
    var raza: String = "",
    var obs: String = "",
    var url_image: String = ""
) : Parcelable
