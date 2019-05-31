package com.example.dzj.android_practice.networkdemo

import android.util.Log
import android.widget.Toast
import com.example.dzj.android_practice.MainActivity
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitTest {
    fun main() {
        //创建Retrofit对象
        val retrofit = Retrofit.Builder()
                .baseUrl("http://www.baidu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client( OkHttpTest.okHttpClient)
                .build();
        //通过retrofit和定义的有网络访问方法的接口关联
        val apiImpl = retrofit.create(Api::class.java);
        val baidu = apiImpl.baidu("http://wwww.baidu.com");
        class CallBackMine :Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d("请求结果", response.body()?.string())
            }
        }
        baidu.enqueue(CallBackMine())



    }
}