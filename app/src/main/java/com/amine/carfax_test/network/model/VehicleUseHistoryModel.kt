package com.amine.carfax_test.network.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VehicleUseHistoryModel(
    var history: List<HistoryModel>? = null,
    var icon: String? = null, // personal
    var iconUrl: String? = null, // https://media.carfax.com/img/vhr/ico_personal.gif
    var text: String? = null // Personal Use
) : Parcelable