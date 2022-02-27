package com.amine.carfax_test.homepage

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amine.carfax_test.network.RetroInstance
import com.amine.carfax_test.network.RetroService
import com.amine.carfax_test.network.model.TempModel
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomePageViewModel : ViewModel() {
//    val carList = MutableLiveData<TempModel>

    val carList = MutableLiveData<TempModel?>(null)


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

            }

            override fun onError(e: Throwable) {
                carList.postValue(null)
            }

            override fun onNext(t: TempModel) {
                carList.postValue(t)
                Log.e("AAA", "onComplete: " + Gson().toJson(t))
            }

            override fun onSubscribe(d: Disposable) {
                //start showing progress indicator.
            }
        }
    }
}