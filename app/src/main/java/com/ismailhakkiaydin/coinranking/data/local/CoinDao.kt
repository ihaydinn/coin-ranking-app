package com.ismailhakkiaydin.coinranking.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ismailhakkiaydin.coinranking.model.coin.CoinResult

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoin(coin : CoinResult.Data.Coin)

    @Delete
    fun deleteCoin(coin: CoinResult.Data.Coin)

    @Query("SELECT * FROM coin_table")
    fun getAllCoins(): LiveData<List<CoinResult.Data.Coin>>

    @Query("SELECT * FROM coin_table WHERE coinId = :coinId")
    fun getSingleCoin(coinId: Int): LiveData<CoinResult.Data.Coin>

}