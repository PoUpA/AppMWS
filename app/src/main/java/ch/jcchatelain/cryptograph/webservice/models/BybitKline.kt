package ch.jcchatelain.cryptograph.webservice.models


import com.google.gson.annotations.SerializedName

data class BybitKline(
    val symbol: String,
    val interval: String,
    @SerializedName("open_time")
    val openTime: Int,
    val `open`: Double,
    val high: Double,
    val low: Double,
    val close: Double,
    val volume: Double,
    val turnover: Double
)