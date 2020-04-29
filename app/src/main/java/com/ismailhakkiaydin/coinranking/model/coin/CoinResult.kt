package com.ismailhakkiaydin.coinranking.model.coin

import com.google.gson.annotations.SerializedName

data class CoinResult(
    @SerializedName("status")
    var status: String,
    @SerializedName("data")
    var `data`: Data
) {
    data class Data(
        @SerializedName("stats")
        var stats: Stats,
        @SerializedName("base")
        var base: Base,
        @SerializedName("coins")
        var coins: List<Coin>
    ) {
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
            var uuid: String,
            @SerializedName("slug")
            var slug: String,
            @SerializedName("symbol")
            var symbol: String,
            @SerializedName("name")
            var name: String,
            @SerializedName("description")
            var description: String,
            @SerializedName("color")
            var color: String,
            @SerializedName("iconType")
            var iconType: String,
            @SerializedName("iconUrl")
            var iconUrl: String,
            @SerializedName("websiteUrl")
            var websiteUrl: String,
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
            var type: String,
            @SerializedName("volume")
            var volume: Long,
            @SerializedName("marketCap")
            var marketCap: Long,
            @SerializedName("price")
            var price: String,
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
            var history: List<String>,
            @SerializedName("allTimeHigh")
            var allTimeHigh: AllTimeHigh,
            @SerializedName("penalty")
            var penalty: Boolean
        ) {
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
        }
    }
}