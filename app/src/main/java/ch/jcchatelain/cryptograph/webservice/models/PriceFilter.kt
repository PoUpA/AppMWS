package ch.jcchatelain.cryptograph.webservice.models


import com.google.gson.annotations.SerializedName

data class PriceFilter(
    @SerializedName("min_price")
    val minPrice: String,
    @SerializedName("max_price")
    val maxPrice: String,
    @SerializedName("tick_size")
    val tickSize: String
)