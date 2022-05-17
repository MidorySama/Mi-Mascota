package com.example.mimascota.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
 class UserRegister(
    var name: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = ""

) : Parcelable
