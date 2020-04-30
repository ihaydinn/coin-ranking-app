package com.ismailhakkiaydin.coinranking.model.coin

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class CoinResult(
    @SerializedName("status")
    var status: String?,
    @SerializedName("data")
    var data: Data
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        TODO("data")
    ) {
    }

    data class Data(
        @SerializedName("stats")
        var stats: Stats,
        @SerializedName("base")
        var base: Base,
        @SerializedName("coins")
        var coins: List<Coin>
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            TODO("stats"),
            TODO("base"),
            TODO("coins")
        ) {
        }

        data class Stats(
            @SerializedName("total")
            var total: Int,
            @SerializedName("offset")
            var offset: Int,
            @SerializedName("limit")
            var limit: Int,
            @SerializedName("order")
            var order: String,
            @SerializedName("base")
            var base: String,
            @SerializedName("totalMarkets")
            var totalMarkets: Int,
            @SerializedName("totalExchanges")
            var totalExchanges: Int,
            @SerializedName("totalMarketCap")
            var totalMarketCap: Double,
            @SerializedName("total24hVolume")
            var total24hVolume: Double
        )

        data class Base(
            @SerializedName("symbol")
            var symbol: String,
            @SerializedName("sign")
            var sign: String
        )

        data class Coin(
            @SerializedName("id")
            var id: Int,
            @SerializedName("uuid")
            var uuid: String?,
            @SerializedName("slug")
            var slug: String?,
            @SerializedName("symbol")
            var symbol: String?,
            @SerializedName("name")
            var name: String?,
            @SerializedName("description")
            var description: String?,
            @SerializedName("color")
            var color: String?,
            @SerializedName("iconType")
            var iconType: String?,
            @SerializedName("iconUrl")
            var iconUrl: String?,
            @SerializedName("websiteUrl")
            var websiteUrl: String?,
            @SerializedName("socials")
            var socials: List<Social>,
            @SerializedName("links")
            var links: List<Link>,
            @SerializedName("confirmedSupply")
            var confirmedSupply: Boolean,
            @SerializedName("numberOfMarkets")
            var numberOfMarkets: Int,
            @SerializedName("numberOfExchanges")
            var numberOfExchanges: Int,
            @SerializedName("type")
            var type: String?,
            @SerializedName("volume")
            var volume: Long,
            @SerializedName("marketCap")
            var marketCap: Long,
            @SerializedName("price")
            var price: String?,
            @SerializedName("circulatingSupply")
            var circulatingSupply: Double,
            @SerializedName("totalSupply")
            var totalSupply: Double,
            @SerializedName("approvedSupply")
            var approvedSupply: Boolean,
            @SerializedName("firstSeen")
            var firstSeen: Long,
            @SerializedName("change")
            var change: Double,
            @SerializedName("rank")
            var rank: Int,
            @SerializedName("history")
            var history: ArrayList<String>?,
            @SerializedName("allTimeHigh")
            var allTimeHigh: AllTimeHigh,
            @SerializedName("penalty")
            var penalty: Boolean
        ) : Parcelable {
            constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                TODO("socials"),
                TODO("links"),
                parcel.readByte() != 0.toByte(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readString(),
                parcel.readLong(),
                parcel.readLong(),
                parcel.readString(),
                parcel.readDouble(),
                parcel.readDouble(),
                parcel.readByte() != 0.toByte(),
                parcel.readLong(),
                parcel.readDouble(),
                parcel.readInt(),
                parcel.createStringArrayList(),
                TODO("allTimeHigh"),
                parcel.readByte() != 0.toByte()
            ) {
            }

            data class Social(
                @SerializedName("name")
                var name: String,
                @SerializedName("url")
                var url: String,
                @SerializedName("type")
                var type: String
            )

            data class Link(
                @SerializedName("name")
                var name: String,
                @SerializedName("type")
                var type: String,
                @SerializedName("url")
                var url: String
            )

            data class AllTimeHigh(
                @SerializedName("price")
                var price: String,
                @SerializedName("timestamp")
                var timestamp: Long
            )

            override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(id)
                parcel.writeString(uuid)
                parcel.writeString(slug)
                parcel.writeString(symbol)
                parcel.writeString(name)
                parcel.writeString(description)
                parcel.writeString(color)
                parcel.writeString(iconType)
                parcel.writeString(iconUrl)
                parcel.writeString(websiteUrl)
                parcel.writeByte(if (confirmedSupply) 1 else 0)
                parcel.writeInt(numberOfMarkets)
                parcel.writeInt(numberOfExchanges)
                parcel.writeString(type)
                parcel.writeLong(volume)
                parcel.writeLong(marketCap)
                parcel.writeString(price)
                parcel.writeDouble(circulatingSupply)
                parcel.writeDouble(totalSupply)
                parcel.writeByte(if (approvedSupply) 1 else 0)
                parcel.writeLong(firstSeen)
                parcel.writeDouble(change)
                parcel.writeInt(rank)
                parcel.writeStringList(history)
                parcel.writeByte(if (penalty) 1 else 0)
            }

            override fun describeContents(): Int {
                return 0
            }

            companion object CREATOR : Parcelable.Creator<Coin> {
                override fun createFromParcel(parcel: Parcel): Coin {
                    return Coin(parcel)
                }

                override fun newArray(size: Int): Array<Coin?> {
                    return arrayOfNulls(size)
                }
            }
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {

        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Data> {
            override fun createFromParcel(parcel: Parcel): Data {
                return Data(parcel)
            }

            override fun newArray(size: Int): Array<Data?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CoinResult> {
        override fun createFromParcel(parcel: Parcel): CoinResult {
            return CoinResult(parcel)
        }

        override fun newArray(size: Int): Array<CoinResult?> {
            return arrayOfNulls(size)
        }
    }
}