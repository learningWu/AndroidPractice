package com.example.dzj.android_practice

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.dzj.android_practice.lithodemo.activity.LithoActivity
import com.example.dzj.android_practice.activity.RoundLayoutShowActivity
import com.example.dzj.android_practice.iodemo.BitmapDecodeTest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        androidx.asynclayoutinflater.view.AsyncLayoutInflater(this).inflate(R.layout.activity_main, null) { view, i, viewGroup ->
            setContentView(view)
            ButterKnife.bind(this@MainActivity)
        }
    }

    fun checkPermission() {
        //检查权限（NEED_PERMISSION）是否被授权 PackageManager.PERMISSION_GRANTED表示同意授权
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //用户已经拒绝过一次，再次弹出权限申请对话框需要给用户一个解释
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission
                            .WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "请开通相关权限，否则无法正常使用本应用！", Toast.LENGTH_SHORT).show();
            }
            //申请权限
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 10);

        } else {
            Toast.makeText(this, "授权成功！", Toast.LENGTH_SHORT).show();
            BitmapDecodeTest(this@MainActivity).main()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("请求：", "" + requestCode);
        when (requestCode) {
            10 -> {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_GRANTED) {
                    BitmapDecodeTest(this@MainActivity).main()
                }
            }
        }
    }

    @OnClick(R.id.tv_to_round_layout_activity, R.id.tv_to_sub_thread_update_ui_activity, R.id.tv_to_litho_activity)
    fun onClick(view: View) {
        when (view.id) {
            R.id.tv_to_round_layout_activity -> {
                val intent = Intent(this@MainActivity, RoundLayoutShowActivity::class.java);
                startActivity(intent)
            }
            R.id.tv_to_litho_activity -> {
                val intent = Intent(this@MainActivity, LithoActivity::class.java);
                startActivity(intent)
            }
            R.id.tv_to_sub_thread_update_ui_activity -> {
//                val intent = Intent(this@MainActivity, SubThreadUpdateUiActivity::class.java);
//                startActivity(intent)
            }
        }
    }
}