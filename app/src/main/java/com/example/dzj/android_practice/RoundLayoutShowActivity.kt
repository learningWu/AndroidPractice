package com.example.dzj.android_practice

import android.os.Bundle
import androidx.asynclayoutinflater.view.AsyncLayoutInflater
import androidx.appcompat.app.AppCompatActivity

class RoundLayoutShowActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        androidx.asynclayoutinflater.view.AsyncLayoutInflater(this).inflate(R.layout.activity_round_layout_show, null) { view, i, viewGroup ->
            setContentView(view)
        }
    }

}