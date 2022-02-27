package com.amine.carfax_test.network.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FacetModel(
    var encodedName: String? = null, // Unspecified
    var name: String? = null, // Unspecified
    var value: Int? = null, // 28
) : Parcelable