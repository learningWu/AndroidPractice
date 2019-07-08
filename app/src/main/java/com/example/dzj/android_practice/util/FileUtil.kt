package com.example.dzj.android_practice.util

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Environment
import java.io.File

val FILE_PATH = "my/project"

/**
 * sd卡上创建文件和得到文件
 *
 * @param path
 * @param fileName
 * @return
 * @throws Exception
 */
fun newFile(path: String, fileName: String): File {
    val pathFile = File(Environment.getExternalStorageDirectory(), path)
    if (!pathFile.exists()) {
        val mkdirs = pathFile.mkdirs()
        if (!mkdirs) {
            //("=====创建文件夹失败=====")
        }
    }
    return File(pathFile, fileName)
}

fun newFile(fileName: String): File {
    return newFile(FILE_PATH, fileName)
}
