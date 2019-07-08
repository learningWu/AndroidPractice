package com.example.dzj.android_practice.memorydemo

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Debug
import android.util.Log
import com.android.tools.perflib.captures.MemoryMappedFileBuffer
import com.example.dzj.android_practice.util.newFile
import com.squareup.haha.perflib.ArrayInstance
import com.squareup.haha.perflib.ClassInstance
import com.squareup.haha.perflib.Instance
import com.squareup.haha.perflib.Snapshot
import okhttp3.internal.Internal.instance
import java.io.File
import java.util.*
import kotlin.collections.HashMap
import android.R
import android.graphics.drawable.BitmapDrawable


class HeapDumpFileTest(var context: Context) {
    //    companion object {
    lateinit var bitmap1: Bitmap
    lateinit var bitmap2: Bitmap
//    }

    val heapDumpFile = newFile("heapDumpFile")

    val hashMap = HashMap<Int, Instance>()


    fun main(): Unit {
        loadDuplicateBitmap()
        Debug.dumpHprofData(heapDumpFile.absolutePath)
        analyseHeapDumpFile()
    }

    /**
     * 加载多个相同 bitmap
     */
    private fun loadDuplicateBitmap() {
        bitmap1 = BitmapFactory.decodeResource(context.resources, com.example.dzj.android_practice.R.mipmap.spid)
        bitmap2 = BitmapFactory.decodeResource(context.resources, com.example.dzj.android_practice.R.mipmap.spid)
    }

    fun analyseHeapDumpFile() {
        val buffer = MemoryMappedFileBuffer(heapDumpFile)
        val snapshot = Snapshot.createSnapshot(buffer)
        // 不加，就会在使用 instance 输出栈引用时，nextInstanceToGcRoot = null
        snapshot.computeDominators()
        val bitmapClass = snapshot.findClass(Bitmap::class.java.name)
        val heaps = snapshot.heaps
        for (heap in heaps) {
            if (!heap.name.equals("app")) {
                continue
            }
            val bitmapInstances = bitmapClass.getHeapInstances(heap.id)
            for (bitmapInstance in bitmapInstances) {
                for (fieldValue in (bitmapInstance as ClassInstance).values) {
                    if (!fieldValue.field.name.equals("mBuffer")) {
                        continue
                    }
                    if (fieldValue.value is ArrayInstance) {
                        val bitmapBuffer = fieldValue.value as ArrayInstance
                        // Arrays.hashCode 对数组内容的 hashCode ，而不是对内存地址 hashCode
                        if (hashMap.get(Arrays.hashCode(bitmapBuffer.values)) == null) {
                            hashMap.put(Arrays.hashCode(bitmapBuffer.values), bitmapInstance)
                        } else {
                            // 说明已经存在一个
                            Log.d("HeapDumpFileTest", "重复图片大小 : " + bitmapBuffer.values.size)
                            // 自己这个
                            printBitmapInfo(bitmapInstance)
                            // 已经重复的那个
                            printBitmapInfo(hashMap.get(Arrays.hashCode(bitmapBuffer.values))!!)
                        }
                    }
                }
            }
        }
    }

    /**
     * find 某个 field 的值
     */
    fun findFieldValue(values: List<ClassInstance.FieldValue>, fieldName: String): String {
        var result = ""
        for (fieldValue in values) {
            if (!fieldValue.field.name.equals(fieldName)) {
                continue
            }
            Log.d("HeapDumpFileTest", "field : ${fieldName} value : ${fieldValue.value}")
            result = fieldValue.value.toString()
        }
        return result
    }

    /**
     * 输出 btimap 信息
     */
    fun printBitmapInfo(bitmapInstance: Instance) {
        val instance = bitmapInstance as ClassInstance
        val fieldValues = instance.values
        findFieldValue(fieldValues, "mWidth")
        findFieldValue(fieldValues, "mHeight")
        findFieldValue(fieldValues, "mBuffer")

        getStackInfo(instance)
    }

    /**
     * 输出引用栈信息
     */
    fun getStackInfo(instance: Instance) {
        if (instance.distanceToGcRoot != 0 && instance.distanceToGcRoot != Integer.MAX_VALUE) {
            getStackInfo(instance.nextInstanceToGcRoot)
        }
        if (instance.nextInstanceToGcRoot != null) {
            Log.d("HeapDumpFileTest", "" + instance.nextInstanceToGcRoot)
        }
    }
}