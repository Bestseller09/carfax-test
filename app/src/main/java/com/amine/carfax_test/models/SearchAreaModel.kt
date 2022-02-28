package com.amine.carfax_test.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchAreaModel(
    var city: String? = null, // Lodi
    var dynamicRadii: List<Int>? = null,
    var dynamicRadius: Boolean? = null, // false
    var latitude: Double? = null, // 40.8785
    var longitude: Double? = null, // -74.0813
    var radius: Int? = null, // 100
    var state: String? = null, // NJ
    var zip: String? = null // 07644
) : Parcelable