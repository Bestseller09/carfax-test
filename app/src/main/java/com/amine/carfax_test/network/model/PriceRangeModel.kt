package com.amine.carfax_test.network.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PriceRangeModel(
    var min: Int? = null // 1
) : Parcelable