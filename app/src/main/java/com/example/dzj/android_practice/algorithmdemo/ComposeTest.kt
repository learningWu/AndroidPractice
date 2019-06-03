package com.example.dzj.android_practice.algorithmdemo

import android.util.Log

/**
 * 组合题
 * 假设现在需要设计一个抽奖系统。需要依次从 100 个人中，抽取三等奖 10 名，二等奖 3 名和一等奖 1 名。请列出所有可能的组合，需要注意的每人最多只能被抽中 1 次。
 */
class ComposeTest {
    val peoples = ArrayList<Int>()

    var composeCount = 0
    fun main() {
        val selectedPeople = ArrayList<Int>()

        //初始化所有人
        for (i in 0..99) {
            peoples.add(i)
        }

        compose(selectedPeople, 0)
    }


    fun compose(selectedPeople: ArrayList<Int>, composeStart: Int) {

        if (selectedPeople.size == 14) {
            Log.d("组合", "组合数${++composeCount}")
            selectedPeople.forEach {
                Log.d("组合", "组合：$it")
            }
            return
        }

        for (i in composeStart..99) {
            val cloneSelectedPeople = selectedPeople.clone() as ArrayList<Int>
            cloneSelectedPeople.add(peoples[i])
            compose(cloneSelectedPeople, i)
        }
    }
}