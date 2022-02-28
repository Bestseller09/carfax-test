package com.amine.carfax_test.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchRequestModel(
    var make: String? = null, // Fiat
    var mileageRange: MileageRangeModel? = null,
    var model: String? = null, // 124 Spider
    var priceRange: PriceRangeModel? = null,
    var radius: Int? = null, // 100
    var srpUrl: String? = null, // https://www.carfax.com/search?make=Fiat&model=124 Spider&zip=07644&radius=100&yearMin=2016&yearMax=2018&priceMin=1
    var webHost: String? = null, // https://www.carfax.com
    var yearRange: YearRangeModel? = null,
    var zip: String? = null // 07644
) : Parcelable