package com.amine.carfax_test.models


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class ImagesModel(
    var baseUrl: String? = null, // https://firebasestorage.googleapis.com/v0/b/carfax-for-consumers.appspot.com
    var firstPhoto: FirstPhotoModel? = null,
    var large: List<String>? = null,
    var medium: List<String>? = null,
    var small: List<String>? = null
) : Parcelable