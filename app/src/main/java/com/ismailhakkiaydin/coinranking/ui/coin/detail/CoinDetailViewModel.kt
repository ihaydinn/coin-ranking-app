package com.ismailhakkiaydin.coinranking.ui.coin.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ismailhakkiaydin.coinranking.data.ApiClient
import com.ismailhakkiaydin.coinranking.model.coin.CoinResult
import com.ismailhakkiaydin.coinranking.model.history.CoinHistoryResult
import com.ismailhakkiaydin.coinranking.ui.favorite.FavoriteRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CoinDetailViewModel(application: Application):AndroidViewModel(application) {

    private val repository: FavoriteRepository by lazy { FavoriteRepository(application.applicationContext) }

    private val apiClient = ApiClient()
    private val disposable = CompositeDisposable()

    val coinHistoryList = MutableLiveData<List<CoinHistoryResult.Data.History>>()
    val loading = MutableLiveData<Boolean>()

    fun insertCoin(coin: CoinResult.Data.Coin) = repository.insertCoin(coin)
    fun deleteCoin(coin: CoinResult.Data.Coin) = repository.deleteCoin(coin)
    fun getAllCoins(): LiveData<List<CoinResult.Data.Coin>> = repository.getAllCoins()
    fun getSingleCoin(coinId: Int): LiveData<CoinResult.Data.Coin> = repository.getSingleCoin(coinId)

    fun getAllCoinHisory(coinId:Int){
        loading.value = true
        disposable.add(
            apiClient.getAllCoinHistory(coinId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<CoinHistoryResult>(){
                    override fun onSuccess(t: CoinHistoryResult) {
                        coinHistoryList.value = t.data.history
                        loading.value = false
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