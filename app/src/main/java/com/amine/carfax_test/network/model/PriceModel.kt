package com.amine.carfax_test.network.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PriceModel(
    var facets: List<FacetModel>? = null
) : Parcelable