package ch.jcchatelain.cryptograph.webservice.models


import com.google.gson.annotations.SerializedName

data class BybitResult(
    @SerializedName("ret_code")
    val retCode: Int,
    @SerializedName("ret_msg")
    val retMsg: String,
    @SerializedName("ext_code")
    val extCode: String,
    @SerializedName("ext_info")
    val extInfo: String,
    val result: List<Any>,
    @SerializedName("time_now")
    val timeNow: String
)