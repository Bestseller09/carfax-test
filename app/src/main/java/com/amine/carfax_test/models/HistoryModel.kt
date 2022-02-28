package com.amine.carfax_test.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HistoryModel(
    var city: String? = null, // Harrington Park
    var endOwnershipDate: String? = null, // 10/31/20
    var ownerNumber: Int? = null, // 1
    var purchaseDate: String? = null, // 10/14/16
    var state: String? = null,

    var date: String? = null, // 06/08/19
    var description: String? = null, // Vehicle serviced <span class='bullet' style='font-weight: bold;'>&#8226;</span> Maintenance inspection completed <span class='bullet' style='font-weight: bold;'>&#8226;</span> Tires rotated <span class='bullet' style='font-weight: bold;'>&#8226;</span> Oil and filter changed.
    var odometerReading: Int? = null, // 5466
    var source: String? = null,

    var averageMilesPerYear: Int? = null, // 1966
    var useType: String? = null // Personal Use

) : Parcelable