package com.amine.carfax_test.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OnePriceArrowModel(
    var arrow: String? = null, // UP
    var arrowUrl: String? = null, // https://media.carfax.com/img/vhr/oneprice/icon-up-med.png
    var icon: String? = null, // noAccident
    var iconUrl: String? = null, // https://media.carfax.com/img/vhr/ico_noAccident.gif
    var order: Int? = null, // 1
    var text: String? = null // No Accidents Reported
) : Parcelable