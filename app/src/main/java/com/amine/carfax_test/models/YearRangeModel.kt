package com.amine.carfax_test.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class YearRangeModel(
    var facets: List<FacetModel>? = null,
    var max: Int? = null, // 2018
    var min: Int? = null // 2016
) : Parcelable