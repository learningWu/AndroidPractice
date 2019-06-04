package com.example.dzj.android_practice

import android.content.Intent
import android.os.Bundle
import androidx.asynclayoutinflater.view.AsyncLayoutInflater
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.annotation.UiThread
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.dzj.android_practice.algorithmdemo.ComposeTest
import com.example.dzj.android_practice.classdemo.AnnotationTest
import com.example.dzj.android_practice.concurrentdemo.FutureTest
import com.example.dzj.android_practice.networkdemo.RetrofitTest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        androidx.asynclayoutinflater.view.AsyncLayoutInflater(this).inflate(R.layout.activity_main, null) { view, i, viewGroup ->
            setContentView(view)
            ButterKnife.bind(this@MainActivity)
        }
        AnnotationTest().main()

    }

    @OnClick(R.id.tv_to_round_layout_activity)
    fun onClick(view: View) {
        when (view.id) {
            R.id.tv_to_round_layout_activity -> {
                val intent = Intent(this@MainActivity, RoundLayoutShowActivity::class.java);
                startActivity(intent)
            }
        }
    }
}