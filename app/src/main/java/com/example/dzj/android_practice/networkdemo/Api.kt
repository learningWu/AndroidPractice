package com.example.dzj.android_practice.networkdemo

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url



interface Api {
    @GET
    fun baidu(@Url url: String): Call<ResponseBody>
}