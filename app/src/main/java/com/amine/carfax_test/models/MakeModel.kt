package com.amine.carfax_test.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MakeModel(
    var facets: List<FacetModel>? = null
) : Parcelable