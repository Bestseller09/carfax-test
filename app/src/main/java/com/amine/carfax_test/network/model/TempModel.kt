package com.amine.carfax_test.network.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TempModel(
    var backfillCount: Int? = null, // 1
    var breadCrumbs: List<BreadCrumbModel>? = null,
    var dealerNewCount: Int? = null, // 17
    var dealerUsedCount: Int? = null, // 11
    var enhancedCount: Int? = null, // 27
    var facetCountMap: FacetCountMapModel? = null,
    var listings: List<ListingsModel>? = null,
    var page: Int? = null, // 1
    var pageSize: Int? = null, // 25
    var relatedLinks: RelatedLinksModel? = null,
    var searchArea: SearchAreaModel? = null,
    var searchRequest: SearchRequestModel? = null,
    var seoUrl: String? = null, // Used-Fiat-124-Spider_w728
    var totalListingCount: Int? = null, // 28
    var totalPageCount: Int? = null // 2
) : Parcelable