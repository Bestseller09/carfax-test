package com.amine.carfax_test.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RelatedLinksModel(
    @SerializedName("Fiat 124 Spider Trim Levels")
    var fiat124SpiderTrimLevels: List<Fiat124SpiderTrimLevelModel>? = null,
    @SerializedName("Similar Cars")
    var similarCars: List<SimilarCarModel>? = null,
    @SerializedName("Used Fiat 124 Spider by Year")
    var usedFiat124SpiderByYear: List<UsedFiat124SpiderByYearModel>? = null
) : Parcelable