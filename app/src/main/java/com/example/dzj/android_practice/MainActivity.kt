package com.example.dzj.android_practice

import android.os.Bundle
import android.support.v4.view.AsyncLayoutInflater
import android.support.v7.app.AppCompatActivity
import android.view.View
import butterknife.OnClick
import com.example.dzj.android_practice.networkdemo.RetrofitTest

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AsyncLayoutInflater(this).inflate(R.layout.activity_main, null) { view, i, viewGroup ->
            setContentView(view)
        }
        RetrofitTest().main()
    }

    @OnClick(R.id.tv_to_round_layout_activity)
    fun onClick(view: View) {
        when (view.id) {
            R.id.tv_to_round_layout_activity -> {

            }
        }
    }
}