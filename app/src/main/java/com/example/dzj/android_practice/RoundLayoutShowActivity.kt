package com.example.dzj.android_practice

import android.os.Bundle
import android.support.v4.view.AsyncLayoutInflater
import android.support.v7.app.AppCompatActivity

class RoundLayoutShowActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AsyncLayoutInflater(this).inflate(R.layout.activity_round_layout_show, null) { view, i, viewGroup ->
            setContentView(view)
        }
    }

}