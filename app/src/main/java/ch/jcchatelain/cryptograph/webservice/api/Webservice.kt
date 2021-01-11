package ch.jcchatelain.cryptograph.webservice.api

import ch.jcchatelain.cryptograph.webservice.models.BybitKlineResult
import ch.jcchatelain.cryptograph.webservice.models.BybitSymbolResult
import ch.jcchatelain.cryptograph.webservice.models.BybitTickerResult
import retrofit2.http.GET
import retrofit2.http.Query

interface Webservice {
    /**
     * @GET declares an HTTP GET request
     * https://api.bybit.com/v2/public/symbols
     */
    @GET("symbols")
    suspend fun getSymbols(): BybitSymbolResult

    /**
     * @GET declares an HTTP GET request
     * https://api.bybit.com/v2/public/tickers
     */
    @GET("tickers")
    suspend fun getTicker(
        @Query("symbol") symbol: String = "BTCUSD"
    ): BybitTickerResult
    /**
     * @GET declares an HTTP GET request
     * https://api.bybit.com/v2/public/kline/list?symbol=BTCUSD&interval=1&limit=2&from=1581231260
     *
     */
    @GET("kline/list")
    suspend fun getKlineInversePerpetual(
        @Query("symbol") symbol: String = "BTCUSD",
        @Query("interval") interval: String = "D",
        @Query("from") fromTime: Long = 0,
        @Query("limit") limit: Int = 200
    ): BybitKlineResult

}