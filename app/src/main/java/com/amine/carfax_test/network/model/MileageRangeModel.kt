package com.amine.carfax_test.network.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MileageRangeModel(
    var facets: List<FacetModel>? = null,
    var max: Int? = null, // 0
    var min: Int? = null // 0
) : Parcelable