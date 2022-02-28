package com.amine.carfax_test.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OwnerHistoryModel(
    var history: List<HistoryModel>? = null,
    var icon: String? = null, // owner1
    var iconUrl: String? = null, // https://media.carfax.com/img/vhr/ico_owner1.gif
    var text: String? = null // CARFAX 1-Owner
) : Parcelable