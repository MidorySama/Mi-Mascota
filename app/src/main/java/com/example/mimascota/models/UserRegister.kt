package com.example.mimascota.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class UserRegister (
    var email: String,
    var name: String,
    var lastName: String,
    var password: String

        ) : Parcelable{}
