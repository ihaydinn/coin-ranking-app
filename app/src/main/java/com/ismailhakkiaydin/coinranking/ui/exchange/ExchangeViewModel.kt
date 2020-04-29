package com.ismailhakkiaydin.coinranking.ui.exchange

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ismailhakkiaydin.coinranking.data.ApiClient
import com.ismailhakkiaydin.coinranking.model.exchange.ExchangeResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ExchangeViewModel(application: Application) : AndroidViewModel(application) {

    private val apiClient = ApiClient()
    private val disposable = CompositeDisposable()

    val exchangeList = MutableLiveData<List<ExchangeResult.Data.Exchange>>()
    val loading = MutableLiveData<Boolean>()

    fun getAllExchanges() {
        loading.value = true
        disposable.add(
            apiClient.getAllExchanges()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ExchangeResult>() {
                    override fun onSuccess(t: ExchangeResult) {
                        exchangeList.value = t.data.exchanges
                        loading.value = false
                        Log.i("Exchange : ", "ÇALIŞTI")
                    }

                    override fun onError(e: Throwable) {
                        Log.i("Exchange : ", "HATA" + e.message + " : " + e.printStackTrace())
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}