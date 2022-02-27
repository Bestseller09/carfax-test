package com.amine.carfax_test.network.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ServiceHistoryModel(
    var history: List<HistoryModel>? = null,
    var icon: String? = null, // service
    var iconUrl: String? = null, // https://media.carfax.com/img/vhr/ico_service.gif
    var number: Int? = null, // 2
    var text: String? = null // Service History
) : Parcelable