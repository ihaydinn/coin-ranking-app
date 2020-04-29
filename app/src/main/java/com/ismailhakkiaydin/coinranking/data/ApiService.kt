package com.ismailhakkiaydin.coinranking.data

import com.ismailhakkiaydin.coinranking.model.coin.CoinResult
import com.ismailhakkiaydin.coinranking.model.exchange.ExchangeResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("x-rapidapi-key: 47141ae9bdmshe17613535a3c8cap10199cjsndef2dcecc7d1")
    @GET("coins")
    fun getAllCoins(): Single<CoinResult>

    @Headers("x-rapidapi-key: 47141ae9bdmshe17613535a3c8cap10199cjsndef2dcecc7d1")
    @GET("exchanges")
    fun getAllExchanges(): Single<ExchangeResult>

}