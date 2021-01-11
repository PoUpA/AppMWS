package ch.jcchatelain.cryptograph.webservice.models


import com.google.gson.annotations.SerializedName

data class LeverageFilter(
    @SerializedName("min_leverage")
    val minLeverage: Float,
    @SerializedName("max_leverage")
    val maxLeverage: Float,
    @SerializedName("leverage_step")
    val leverageStep: String
)