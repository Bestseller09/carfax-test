package com.amine.carfax_test.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SimilarCarModel(
    var text: String? = null, // Alfa Romeo Spider For Sale
    var url: String? = null // https://www.carfax.com/Used-Alfa-Romeo-Spider_w681
) : Parcelable