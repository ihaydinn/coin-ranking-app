package com.ismailhakkiaydin.coinranking.data

import com.ismailhakkiaydin.coinranking.model.coin.CoinResult
import com.ismailhakkiaydin.coinranking.model.exchange.ExchangeResult
import com.ismailhakkiaydin.coinranking.util.Constant
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val api = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun getAllCoins(): Single<CoinResult>{
        return api.getAllCoins()
    }

    fun getAllExchanges(): Single<ExchangeResult>{
        return api.getAllExchanges()
    }


}