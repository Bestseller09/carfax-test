package com.amine.carfax_test.network.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListingsModel(
    var accidentHistory: AccidentHistoryModel? = null,
    var advantage: Boolean? = null, // true
    var atomOtherOptions: List<String>? = null,
    var atomTopOptions: List<String>? = null,
    var backfill: Boolean? = null, // false
    var badge: String? = null, // GREAT
    var bedLength: String? = null, // Unspecified
    var bodytype: String? = null, // Convertible
    var cabType: String? = null, // Unspecified
    var certified: Boolean? = null, // false
    var currentPrice: Int? = null, // 22297
    var dealer: DealerModel? = null,
    var dealerType: String? = null, // USED
    var displacement: String? = null, // 1.4 L
    var distanceToDealer: Double? = null, // 0.1579388564928069
    var drivetype: String? = null, // RWD
    var engine: String? = null, // 4 Cyl
    var exteriorColor: String? = null, // Gray
    var firstSeen: String? = null, // 2020-10-31
    var followCount: Int? = null, // 8
    var followedAt: Long? = null, // 1610728373000
    var following: Boolean? = null, // true
    var fuel: String? = null, // Gasoline
    var hasViewed: Boolean? = null, // false
    var id: String? = null, // JC1NFAEK3H0108772ZVF6RAG00120201031
    var imageCount: Int? = null, // 34
    var images: ImagesModel? = null,
    var interiorColor: String? = null, // Unspecified
    var isEnriched: Boolean? = null, // false
    var isOemPromoted: Boolean? = null, // false
    var isOemRefundFlag: Boolean? = null, // false
    var listPrice: Int? = null, // 22297
    var listingStatus: String? = null, // PRICE DROP
    var make: String? = null, // Fiat
    var mileage: Int? = null, // 7963
    var model: String? = null, // 124 Spider
    var monthlyPaymentEstimate: MonthlyPaymentEstimateModel? = null,
    var mpgCity: Int? = null, // 25
    var mpgHighway: Int? = null, // 36
    var noAccidents: Boolean? = null, // true
    var oneOwner: Boolean? = null, // true
    var onePrice: Int? = null, // 23620
    var onePriceArrows: List<OnePriceArrowModel>? = null,
    var onlineOnly: Boolean? = null, // false
    var ownerHistory: OwnerHistoryModel? = null,
    var personalUse: Boolean? = null, // true
    var placed: Boolean? = null, // false
    var recordType: String? = null, // ENHANCED
    var sentLead: Boolean? = null, // false
    var serviceHistory: ServiceHistoryModel? = null,
    var serviceRecords: Boolean? = null, // true
    var sortScore: Double? = null, // 185.45
    var stockNumber: String? = null, // 108772
    var subTrim: String? = null, // Unspecified
    var topOptions: List<String>? = null,
    var tpCostPerVdp: Double? = null, // 0.09
    var tpEligible: Boolean? = null, // false
    var transmission: String? = null, // Automatic
    var trim: String? = null, // Abarth
    var vdpUrl: String? = null, // https://www.carfax.com/vehicle/JC1NFAEK3H0108772
    var vehicleCondition: String? = null, // Used
    var vehicleUseHistory: VehicleUseHistoryModel? = null,
    var vin: String? = null, // JC1NFAEK3H0108772
    var windowSticker: String? = null, // https://www.carfax.com/phoenix/sticker/v3/FIAT/s3dJwm1yI21EQFQyCZyog4TS6t3e9XKkGkEyTi3o95Y.cfx
    var     year: Int? = null // 2017
) : Parcelable