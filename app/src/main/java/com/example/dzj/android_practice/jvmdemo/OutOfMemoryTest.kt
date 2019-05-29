package com.example.dzj.android_practice.JvmTest

class OutOfMemoryTest {
    fun main() {
        //100 m 字节
        var byteArray = ByteArray(104857600)
    }
}