package com.example.dzj.android_practice.iodemo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dzj.android_practice.R
import java.io.*
import java.util.*

/**
 * 测试不同 io 方法对获取bitmap的性能问题
 */

class BitmapDecodeTest(val context: Context) {
    val fileName = "/mydir/testbig.jpeg"
    fun main(): Unit {
        writeOneFile()
        val file = File(Environment.getExternalStorageDirectory(), fileName)

        val decodeFileStartDate = Date()
        repeat(100) {
            val decodeFileBitmap = BitmapFactory.decodeFile(file.absolutePath)
        }
        val decodeFileEndDate = Date()
        Log.d("file：", "decodeFile耗时" + (decodeFileEndDate.time - decodeFileStartDate.time))

        val decodeStreamStartDate = Date()
        repeat(100) {
            val decodeStreamBitmap = BitmapFactory.decodeStream(BufferedInputStream(FileInputStream(file.absolutePath)))
        }
        val decodeStreamEndDate = Date()
        Log.d("file：", "decodeStream耗时" + (decodeStreamEndDate.time - decodeStreamStartDate.time))

    }

    private fun writeOneFile() {
        try {
            val decodeResource = BitmapFactory.decodeResource(context.resources, R.mipmap.testbig)
            val byteOutStream = ByteArrayOutputStream()
            decodeResource.compress(Bitmap.CompressFormat.JPEG, 100, byteOutStream)
            val byteArray = byteOutStream.toByteArray()
            val dir = File(Environment.getExternalStorageDirectory(), "/mydir")
            if (!dir.exists()) {
                val success = dir.mkdir()
                if (!success) {
                    Log.d("file：", "创建文件失败")
                }
            }
            val file = File(Environment.getExternalStorageDirectory(), fileName)
            val bufferedOutputStream = BufferedOutputStream(FileOutputStream(file))
            bufferedOutputStream.write(byteArray)
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

    }
}