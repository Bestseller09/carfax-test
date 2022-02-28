package com.amine.carfax_test.models


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Fiat124SpiderTrimLevelModel(
    var count: Int? = null, // 13
    var text: String? = null, // Fiat 124 Spider Classica
    var url: String? = null // https://www.carfax.com/Used-Fiat-124-Spider-Classica_t7491
) : Parcelable