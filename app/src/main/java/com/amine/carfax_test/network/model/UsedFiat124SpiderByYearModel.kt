package com.amine.carfax_test.network.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UsedFiat124SpiderByYearModel(
    var count: Int? = null, // 28
    var text: String? = null, // 2018 Fiat 124 Spider For Sale
    var url: String? = null // https://www.carfax.com/Used-2018-Fiat-124-Spider_z33983
) : Parcelable