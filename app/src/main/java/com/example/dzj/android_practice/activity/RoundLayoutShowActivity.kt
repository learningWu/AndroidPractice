package com.example.dzj.android_practice.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dzj.android_practice.R

class RoundLayoutShowActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        androidx.asynclayoutinflater.view.AsyncLayoutInflater(this).inflate(R.layout.activity_round_layout_show, null) { view, i, viewGroup ->
            setContentView(view)
        }
    }

}