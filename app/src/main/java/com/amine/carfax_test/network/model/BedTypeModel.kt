package com.amine.carfax_test.network.model


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class BedTypeModel(
    var facets: List<FacetModel>? = null
) : Parcelable