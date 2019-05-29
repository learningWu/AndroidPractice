package com.example.dzj.android_practice

import android.support.v4.view.AsyncLayoutInflater
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dzj.android_practice.algorithmdemo.PermutationTest

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AsyncLayoutInflater(this).inflate(R.layout.activity_main, null) { view, i, viewGroup ->
            setContentView(view)
        }
        PermutationTest().main()
    }
}