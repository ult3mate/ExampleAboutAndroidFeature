package com.pattadon.sampleapplicationproject.network


import com.pattadon.sampleapplicationproject.R
import com.pattadon.sampleapplicationproject.manager.ContexterManager
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 * Created by Pattadon on 18/2/2559.
 * 23Perspective Android Team
 */
class RetrofitManager private constructor() {
    val retrofit: Retrofit
    private val retrofitWithoutCache: Retrofit

    private val FORCE_REWRITE_CACHE_CONTROL_INTERCEPTOR = Interceptor { chain ->
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder()
        val response = chain.proceed(request.build())
        response.newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public, max-age=2419220")
                .build()
    }

    private val REWRITE_CACHE_CONTROL_INTERCEPTOR = Interceptor { chain ->
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder()
        if (NetworkHelper.isNetworkAvailable(ContexterManager.getInstance().getApplicationContext())) {
            request.cacheControl(CacheControl.FORCE_NETWORK)
        }
        val response = chain.proceed(request.build())
        response.newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public, max-age=2419220")
                .build()

    }

    init {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        val httpCacheDirectory = File(ContexterManager.getInstance().getApplicationContext().getCacheDir(),
                ContexterManager.getInstance().getApplicationContext().getPackageName())
        val cache = Cache(httpCacheDirectory, cacheSize.toLong())


        val client = OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .addNetworkInterceptor(FORCE_REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(ContexterManager.getInstance().getApplicationContext().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        retrofitWithoutCache = Retrofit.Builder()
                .baseUrl(ContexterManager.getInstance().getApplicationContext().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    fun getRetrofitWithoutCache(): Retrofit {
        return retrofit
    }

    companion object {
        var retrofitManager: RetrofitManager = RetrofitManager()

        val instance: RetrofitManager
            get() {
                return retrofitManager
            }
    }
}
