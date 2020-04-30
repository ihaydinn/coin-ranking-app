package com.ismailhakkiaydin.coinranking.ui.coin.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ismailhakkiaydin.coinranking.data.ApiClient
import com.ismailhakkiaydin.coinranking.model.history.CoinHistoryResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CoinDetailViewModel(application: Application):AndroidViewModel(application) {

    private val apiClient = ApiClient()
    private val disposable = CompositeDisposable()

    val coinHistoryList = MutableLiveData<List<CoinHistoryResult.Data.History>>()
    val loading = MutableLiveData<Boolean>()

    fun getAllCoinHisory(coinId:Int){
        disposable.add(
            apiClient.getAllCoinHistory(coinId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<CoinHistoryResult>(){
                    override fun onSuccess(t: CoinHistoryResult) {
                        coinHistoryList.value = t.data.history
                    }

                    override fun onError(e: Throwable) {

                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}