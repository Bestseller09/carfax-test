package com.amine.carfax_test.homepage

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amine.carfax_test.network.RetroInstance
import com.amine.carfax_test.network.RetroService
import com.amine.carfax_test.models.TempModel
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomePageViewModel : ViewModel() {

    val carList = MutableLiveData<TempModel?>(null)
    val carLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()


    fun makeApiCall() {

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        retroInstance.getCarListFromApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getCarListObserverRx())
    }

    private fun getCarListObserverRx(): Observer<TempModel> {
        return object : Observer<TempModel> {
            override fun onComplete() {
                //hide progress indicator .
                carLoadError.value = false
                loading.value = false
            }

            override fun onError(e: Throwable) {
                carList.postValue(null)
                carLoadError.value = true
                loading.value = false
            }

            override fun onNext(t: TempModel) {
                carList.postValue(t)
                carLoadError.value = false
                loading.value = false
                Log.d("HomePageViewModel", "onComplete: " + Gson().toJson(t))
            }

            override fun onSubscribe(d: Disposable) {
                //start showing progress indicator.
                carLoadError.value = false
            }
        }
    }
}