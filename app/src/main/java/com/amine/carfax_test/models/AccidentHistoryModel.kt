package com.amine.carfax_test.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AccidentHistoryModel(
    var accidentSummary: List<String>? = null,
    var icon: String? = null, // noAccident
    var iconUrl: String? = null, // https://media.carfax.com/img/vhr/ico_noAccident.gif
    var text: String? = null // No Accident or Damage Reported
) : Parcelable