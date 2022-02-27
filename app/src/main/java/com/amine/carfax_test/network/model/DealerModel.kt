package com.amine.carfax_test.network.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DealerModel(
    var address: String? = null, // 91 US HIGHWAY 46 W
    var backfill: Boolean? = null, // false
    var carfaxId: String? = null, // ZVF6RAG001
    var cfxMicrositeUrl: String? = null, // https://www.carfax.com/Dealer-European-Auto-Expo-LODI-NJ_VZ6FRAG001
    var city: String? = null, // LODI
    var dealerAverageRating: Double? = null, // 4.5
    var dealerInventoryUrl: String? = null, // http://europeanautoexpo.com
    var dealerLeadType: String? = null,
    var dealerReviewComments: String? = null, // My friend recommended it to me and now its my turn! Extended warranty, free maintenance, fair price and friendly staff - all in one place. It was a great pleasure buying a car from you guys!
    var dealerReviewCount: Int? = null, // 88
    var dealerReviewDate: String? = null, // 2021-01-12 10:42:44
    var dealerReviewRating: Int? = null, // 5
    var dealerReviewReviewer: String? = null, // Esther C.
    var dealerReviewTitle: String? = null,
    var latitude: String? = null, // 40.880407
    var longitude: String? = null, // -74.079633
    var name: String? = null, // European Auto Expo
    var onlineOnly: Boolean? = null, // false
    var phone: String? = null, // 8334039932
    var state: String? = null, // NJ
    var zip: String? = null // 07644-3625
) : Parcelable