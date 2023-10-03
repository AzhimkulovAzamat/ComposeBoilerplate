package net.breez.data.rest

import com.google.gson.GsonBuilder
import net.breez.data.extenstions.setSafeLevel
import net.breez.data.rest.api.ProfileApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClientImpl constructor(baseUrl: String) : RestClient {

    private val retrofit: Retrofit

    companion object {
        private const val DEFAULT_TIMEOUT_IN_SECONDS: Long = 60
    }

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setSafeLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClientBuilder = OkHttpClient.Builder()
            .readTimeout(DEFAULT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(DEFAULT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)

        val gson = GsonBuilder()
            .create()

        this.retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClientBuilder.build())
            .build()
    }

    override fun getProfileApi(): ProfileApi {
        return retrofit.create(ProfileApi::class.java)
    }
}