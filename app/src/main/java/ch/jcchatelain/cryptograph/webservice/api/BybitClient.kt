package ch.jcchatelain.cryptograph.webservice.api;

import com.google.gson.GsonBuilder
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

const val BASEURL = "https://api.bybit.com/v2/public/";

public class BybitClient {
    companion object {
        val retrofit: Webservice = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(Webservice::class.java)
    }
}
