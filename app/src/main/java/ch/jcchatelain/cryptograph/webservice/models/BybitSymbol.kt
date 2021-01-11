package ch.jcchatelain.cryptograph.webservice.models


import com.google.gson.annotations.SerializedName

data class BybitSymbol(
    val name: String,
    @SerializedName("base_currency")
    val baseCurrency: String,
    @SerializedName("quote_currency")
    val quoteCurrency: String,
    @SerializedName("price_scale")
    val priceScale: Int,
    @SerializedName("taker_fee")
    val takerFee: String,
    @SerializedName("maker_fee")
    val makerFee: String,
    @SerializedName("leverage_filter")
    val leverageFilter: LeverageFilter,
    @SerializedName("price_filter")
    val priceFilter: PriceFilter,
    @SerializedName("lot_size_filter")
    val lotSizeFilter: LotSizeFilter
)