package com.example.dzj.android_practice.algorithmdemo

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

/**
 * 给定一个数，得出 乘积为这个数的组合方式
 * 未完成
 */
class RecursionTest {

    var sum = 4;

    fun main() {
        compose(ArrayList())
    }

    fun compose(composeArray: ArrayList<Int>) {
        var tempSum = 1;
        composeArray.forEach {
            tempSum = it * tempSum
        }
        if (tempSum > sum) return
        if (tempSum == sum) {
            Log.d("array:", composeArray.toString())
            return
        }
        for (i in 1..sum) {
            val copyArray: ArrayList<Int> = composeArray.clone() as ArrayList<Int>;
            copyArray.add(i)
            compose(copyArray)
        }
    }
}