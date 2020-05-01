package com.ismailhakkiaydin.coinranking.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ismailhakkiaydin.coinranking.model.coin.CoinResult

@Database(entities = [CoinResult.Data.Coin::class], version = 5)
abstract class CoinDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao

    companion object {
        @Volatile
        var instance: CoinDatabase? = null

        @Synchronized
        fun getInstance(context: Context): CoinDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    CoinDatabase::class.java,
                    "coins.db"
                ).fallbackToDestructiveMigration().build()
            }
            return instance as CoinDatabase
        }
    }
}