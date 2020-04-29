package com.ismailhakkiaydin.coinranking.model.history


import com.google.gson.annotations.SerializedName

data class CoinHistoryResult(
    @SerializedName("status")
    var status: String?,
    @SerializedName("data")
    var `data`: Data?
) {
    data class Data(
        @SerializedName("stats")
        var stats: Stats?,
        @SerializedName("currencies")
        var currencies: List<Currency?>?,
        @SerializedName("exchanges")
        var exchanges: List<Exchange?>?
    ) {
        data class Stats(
            @SerializedName("volume")
            var volume: Double?,
            @SerializedName("total")
            var total: Int?,
            @SerializedName("limit")
            var limit: Int?,
            @SerializedName("offset")
            var offset: Int?
        )

        data class Currency(
            @SerializedName("id")
            var id: Int?,
            @SerializedName("uuid")
            var uuid: String?,
            @SerializedName("type")
            var type: String?,
            @SerializedName("iconUrl")
            var iconUrl: String?,
            @SerializedName("name")
            var name: String?,
            @SerializedName("symbol")
            var symbol: String?,
            @SerializedName("sign")
            var sign: String?
        )

        data class Exchange(
            @SerializedName("id")
            var id: Int?,
            @SerializedName("uuid")
            var uuid: String?,
            @SerializedName("name")
            var name: String?,
            @SerializedName("description")
            var description: String?,
            @SerializedName("iconUrl")
            var iconUrl: String?,
            @SerializedName("websiteUrl")
            var websiteUrl: String?,
            @SerializedName("verified")
            var verified: Boolean?,
            @SerializedName("lastTickerCreatedAt")
            var lastTickerCreatedAt: Long?,
            @SerializedName("numberOfMarkets")
            var numberOfMarkets: Int?,
            @SerializedName("volume")
            var volume: Double?,
            @SerializedName("rank")
            var rank: Int?,
            @SerializedName("marketShare")
            var marketShare: Double?
        )
    }
}