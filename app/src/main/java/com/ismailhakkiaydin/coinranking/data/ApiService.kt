package com.ismailhakkiaydin.coinranking.data

import com.ismailhakkiaydin.coinranking.model.coin.CoinResult
import com.ismailhakkiaydin.coinranking.model.exchange.ExchangeResult
import com.ismailhakkiaydin.coinranking.model.history.CoinHistoryResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {

    @Headers("x-rapidapi-key: 47141ae9bdmshe17613535a3c8cap10199cjsndef2dcecc7d1")
    @GET("coins")
    fun getAllCoins(): Single<CoinResult>

    @Headers("x-rapidapi-key: 47141ae9bdmshe17613535a3c8cap10199cjsndef2dcecc7d1")
    @GET("exchanges")
    fun getAllExchanges(): Single<ExchangeResult>

    @Headers("x-rapidapi-key: 47141ae9bdmshe17613535a3c8cap10199cjsndef2dcecc7d1")
    @GET("coin/{id}/history/7d")
    fun getAllCoinHistory(@Path("id") coinId: Int): Single<CoinHistoryResult>

}