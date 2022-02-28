package com.amine.carfax_test.network

import com.amine.carfax_test.models.TempModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RetroService {
    @GET("assignment.json")
    fun getCarListFromApi(): Observable<TempModel>
}