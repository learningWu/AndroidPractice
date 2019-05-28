package com.example.dzj.android_practice.algorithmdemo

import android.util.Log

/**
 * 排列组合问题
 */

class PermutationTest {
    val password = "eeab"

    val targetArray = arrayOf("a", "b", "c", "d", "e")
    fun main() {
        compose(ArrayList<String>())
    }

    private fun compose(arrayList: ArrayList<String>) {
        if (arrayList.size == password.length) {
//            var result = ""
//            arrayList.forEach {
//                result += it
//            }
//            Log.d("结果：", result)
            compare(arrayList)
            return
        }

        for (i in 0 until targetArray.size) {
            val cloneArray = arrayList.clone() as ArrayList<String>
            cloneArray.add(targetArray[i])
            compose(cloneArray)
        }
    }

    private fun compare(arrayList: ArrayList<String>) {
        var equal = true
        for (i in 0 until password.length) {
            if (arrayList[i] != (password[i] + "")) {
                equal = false
            }
        }
        if (equal) {
            var result = ""
            arrayList.forEach {
                result += it
            }
            Log.d("结果：", result)
        }
    }
}