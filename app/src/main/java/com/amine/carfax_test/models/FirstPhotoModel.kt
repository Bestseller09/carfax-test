package com.amine.carfax_test.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FirstPhotoModel(
    var large: String? = null, // https://firebasestorage.googleapis.com/v0/b/carfax-for-consumers.appspot.com/o/1024x768%2Fabarth-124-spider-70esimo-anniversario-fiat-car-blac.jpeg?alt=media&token=d757f902-1f4b-4871-8f8e-d1454bb01ebe
    var medium: String? = null, // https://firebasestorage.googleapis.com/v0/b/carfax-for-consumers.appspot.com/o/640x480%2Fabarth-124-spider-70esimo-anniversario-fiat-car-blac.jpeg?alt=media&token=b4317bf8-9ce1-41d9-9bb1-05dbf208747a
    var small: String? = null // https://firebasestorage.googleapis.com/v0/b/carfax-for-consumers.appspot.com/o/320x240%2Fabarth-124-spider-70esimo-anniversario-fiat-car-blac.jpeg?alt=media&token=7b870327-97ea-4aa9-b181-a253c14de5eb
) : Parcelable