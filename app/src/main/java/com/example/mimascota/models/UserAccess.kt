package com.example.mimascota.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserAccess(
    var email: String = "",
    var password: String = "",
) : Parcelable
