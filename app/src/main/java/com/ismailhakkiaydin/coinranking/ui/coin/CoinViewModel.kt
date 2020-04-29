package com.ismailhakkiaydin.coinranking.ui.coin

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ismailhakkiaydin.coinranking.data.ApiClient
import com.ismailhakkiaydin.coinranking.model.coin.CoinResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val apiClient = ApiClient()
    private val disposable = CompositeDisposable()

    val coinsList = MutableLiveData<List<CoinResult.Data.Coin>>()
    val loading = MutableLiveData<Boolean>()

    fun getAllCoins() {
        loading.value = true
        disposable.add(
            apiClient.getAllCoins()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<CoinResult>() {
                    override fun onSuccess(t: CoinResult) {
                        coinsList.value = t.data.coins
                        loading.value = false
                        Log.i("Coin : ", "ÇALIŞTI")
                    }

                    override fun onError(e: Throwable) {
                        Log.i("Coin : ", "HATA" + e.message + " : " + e.printStackTrace())
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}