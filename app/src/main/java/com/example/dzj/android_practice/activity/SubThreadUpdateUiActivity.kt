package com.example.dzj.android_practice.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.example.dzj.android_practice.R
import java.lang.Exception
import java.util.concurrent.Executors

class SubThreadUpdateUiActivity : AppCompatActivity() {

    @BindView(R.id.tv)
    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_thread_update_ui)
        ButterKnife.bind(this@SubThreadUpdateUiActivity)
    }

    override fun onResume() {
        super.onResume()
        Executors.newCachedThreadPool().submit {
            Looper.prepare()
            var handle = object : Handler() {
                override fun handleMessage(msg: Message?) {
                    try {
                        Log.d("parent：",tv.parent.toString())
                        tv.setText("嘿嘿嘿嘿嘿")
                        Log.d("线程","子线程id："+Thread.currentThread().id+"主线程id："+Looper.getMainLooper().thread.id)
                    }catch (exception:Exception){
                        exception.printStackTrace()
                    }
                }
            }
            //设置为延迟1000就会报子线程不能更新错误，因为在onResume时，viewRootImpl还没创建。
            handle.sendEmptyMessageDelayed(1,1000)
            Looper.loop()
        }
    }

}