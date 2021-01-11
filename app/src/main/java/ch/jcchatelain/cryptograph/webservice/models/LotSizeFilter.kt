package ch.jcchatelain.cryptograph.webservice.models


import com.google.gson.annotations.SerializedName

data class LotSizeFilter(
    @SerializedName("max_trading_qty")
    val maxTradingQty: Float,
    @SerializedName("min_trading_qty")
    val minTradingQty: Float,
    @SerializedName("qty_step")
    val qtyStep: Float
)