package com.amine.carfax_test.models


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class BreadCrumbModel(
    var label: String? = null, // Home
    var link: String? = null, // https://www.carfax.com
    var position: Int? = null // 1
) : Parcelable