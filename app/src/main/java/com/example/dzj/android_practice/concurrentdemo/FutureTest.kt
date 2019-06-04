package com.example.dzj.android_practice.concurrentdemo

import java.util.concurrent.*

class FutureTest {

    fun main(): Unit {
        futureTaskWithCallable()
    }

    fun futureWithCallable(): Unit {
        val newCachedThreadPool = Executors.newCachedThreadPool()
        val submit = newCachedThreadPool.submit(Task())
        newCachedThreadPool.shutdown()
        System.out.println("task运行结果" + submit.get())
    }

    fun futureTaskWithCallable(): Unit {
        //第一种方式 ExecutorService
        val newCachedThreadPool = Executors.newCachedThreadPool()
        val futureTask = FutureTask<Int>(Task())
        newCachedThreadPool.submit(futureTask)
        newCachedThreadPool.shutdown()
        System.out.println("task运行结果ExecutorService:" + futureTask.get())

        //第二种方式 Thread
        val futureTask2 = FutureTask<Int>(Task())
        val thread = Thread(futureTask2)
        thread.start()
        System.out.println("task运行结果Thread:" + futureTask2.get())

    }

    internal class RunTask : Runnable {
        @Throws(Exception::class)
        override fun run() {
            println("子线程在进行计算")
            Thread.sleep(3000)
            var sum = 0
            for (i in 0..99)
                sum += i
            println("子线程在进行计算:$sum")
        }
    }

    internal class Task : Callable<Int> {
        @Throws(Exception::class)
        override fun call(): Int? {
            println("子线程在进行计算")
            Thread.sleep(3000)
            var sum = 0
            for (i in 0..99)
                sum += i
            return sum
        }
    }
}

