package com.eddie.viewdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class MainActivity : AppCompatActivity() {
    @BindView(R.id.group_view)
    lateinit var groupView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.group_view, R.id.btn_show)
    fun onClick(view: View) {
        when (view.id) {
            R.id.group_view -> {
                Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show();
                groupView.visibility = View.GONE

            }
            R.id.btn_show -> {
                groupView.visibility = View.VISIBLE
            }
        }
    }
}
