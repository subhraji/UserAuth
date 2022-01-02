package com.example.userauth.model.network

import android.content.Context
import com.example.userauth.BuildConfig
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    private var mRetrofit: Retrofit? = null
    private val mLoggingInterceptor = HttpLoggingInterceptor()

    private val httpLogClient: OkHttpClient
        get() {
            if (BuildConfig.DEBUG) {
                mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }

            return OkHttpClient.Builder()
                .addInterceptor(mLoggingInterceptor)
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
        }

    val client: Retrofit
        get() {
            if (mRetrofit == null) {
                mRetrofit = Retrofit.Builder()
                    .baseUrl(APIConstants.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpLogClient)
                    .build()
            }
            return mRetrofit!!
        }

    companion object {
        fun getInstance(context: Context): ApiInterface = ApiClient().client
            .create(ApiInterface::class.java)
    }
}