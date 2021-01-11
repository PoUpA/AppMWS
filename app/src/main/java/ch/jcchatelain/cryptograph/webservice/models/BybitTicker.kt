package ch.jcchatelain.cryptograph.webservice.models

import com.google.gson.annotations.SerializedName


data class BybitTicker(
    val symbol: String,
    @SerializedName("bid_price")
    val bidPrice: Float,
    @SerializedName("ask_price")
    val askPrice: Float,
    @SerializedName("last_price")
    val lastPrice: Float,
    @SerializedName("last_tick_direction")
    val lastTickDirection: String,
    @SerializedName("prev_price_24h")
    val prevPrice24h: Float,
    @SerializedName("price_24h_pcnt")
    val price24hPcnt: Float,
    @SerializedName("high_price_24h")
    val highPrice24h: Float,
    @SerializedName("low_price_24h")
    val lowPrice24h: Float,
    @SerializedName("prev_price_1h")
    val prevPrice1h: Float,
    @SerializedName("price_1h_pcnt")
    val price1hPcnt: Float,
    @SerializedName("mark_price")
    val markPrice: Float,
    @SerializedName("index_price")
    val indexPrice: Float,
    @SerializedName("open_interest")
    val openInterest: Float,
    @SerializedName("open_value")
    val openValue: Float,
    @SerializedName("total_turnover")
    val totalTurnover: Float,
    @SerializedName("turnover_24h")
    val turnover24h: Float,
    @SerializedName("total_volume")
    val totalVolume: Float,
    @SerializedName("volume_24h")
    val volume24h: Float,
    @SerializedName("funding_rate")
    val fundingRate: Float,
    @SerializedName("predicted_funding_rate")
    val predictedFundingRate: Float,
    @SerializedName("next_funding_time")
    val nextFundingTime: String,
    @SerializedName("countdown_hour")
    val countdownHour: String
)