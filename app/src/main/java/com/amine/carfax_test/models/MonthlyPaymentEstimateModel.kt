package com.amine.carfax_test.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MonthlyPaymentEstimateModel(
    var downPaymentAmount: Double? = null, // 2229.7000000000003
    var downPaymentPercent: Int? = null, // 10
    var interestRate: Int? = null, // 4
    var loanAmount: Double? = null, // 20067.3
    var monthlyPayment: Double? = null, // 369.57
    var price: Int? = null, // 22297
    var termInMonths: Int? = null // 60
) : Parcelable