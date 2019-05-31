package com.example.dzj.android_practice.networkdemo

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.internal.Util.hostHeader
import okhttp3.internal.Version
import okhttp3.internal.http.HttpHeaders
import okhttp3.internal.http.RealResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import okio.GzipSource
import okio.Okio

class OkHttpTest {

    fun main() {
    }

    companion object OkHttpClient {
        var logInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
            get() {
                field.setLevel(HttpLoggingInterceptor.Level.BODY)
                return field
            }
        private set(value) = Unit

        val okHttpClient = OkHttpClient()
                .newBuilder()
                .addInterceptor(logInterceptor)
                .build()

    }

    class MyInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {

            val request = chain.request()

            val requestBuild = request.newBuilder()
            return Response.Builder().build()

        }

    }
}