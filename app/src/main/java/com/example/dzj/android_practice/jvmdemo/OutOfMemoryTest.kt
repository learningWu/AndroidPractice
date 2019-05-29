package com.example.dzj.android_practice.jvmdemo

class OutOfMemoryTest {
    fun main() {
        //100 m 字节
        var byteArray = ByteArray(104857600)
    }
}