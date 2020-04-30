package com.ismailhakkiaydin.coinranking.ui.favorite

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.ismailhakkiaydin.coinranking.data.local.CoinDao
import com.ismailhakkiaydin.coinranking.data.local.CoinDatabase
import com.ismailhakkiaydin.coinranking.model.coin.CoinResult

class FavoriteRepository(context: Context) {

    private val db: CoinDatabase by lazy {
        CoinDatabase.getInstance(context)
    }

    private val dao: CoinDao by lazy {
        db.coinDao()
    }

    fun insertCoin(coin:CoinResult.Data.Coin){
        InsertAsyncTask(dao).execute(coin)
    }

    fun deleteCoin(coin:CoinResult.Data.Coin){
        DeleteAsyncTask(dao).execute(coin)
    }

    fun getAllCoins(): LiveData<List<CoinResult.Data.Coin>>{
        return dao.getAllCoins()
    }

    fun getSingleCoin(coinId:Int): LiveData<CoinResult.Data.Coin>{
        return dao.getSingleCoin(coinId)
    }

    private class InsertAsyncTask(val dao: CoinDao) : AsyncTask<CoinResult.Data.Coin, Void, Void>() {
        override fun doInBackground(vararg params: CoinResult.Data.Coin): Void? {
            dao.insertCoin(params[0])
            return null
        }
    }

    private class DeleteAsyncTask(val dao: CoinDao) : AsyncTask<CoinResult.Data.Coin, Void, Void>(){
        override fun doInBackground(vararg params: CoinResult.Data.Coin): Void? {
            dao.deleteCoin(params[0])
            return null
        }

    }

}