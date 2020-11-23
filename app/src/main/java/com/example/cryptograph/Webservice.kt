package com.example.cryptograph

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Webservice {
    /**
     * @GET declares an HTTP GET request
     * @Path("priceGraph") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("/pricegraph/{pricegraph}")
    fun getUser(@Path("user") userId: String): Call<PriceGraph>
}