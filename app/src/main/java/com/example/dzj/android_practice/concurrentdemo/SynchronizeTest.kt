package com.example.dzj.android_practice.concurrentdemo

class SynchronizeTest {
    val a = "monitor"
    fun main(): Unit {

        Thread(Runnable { funWithMonitor() }).start()
        Thread.sleep(1000)
        Thread(Runnable { noMonitor() }).start()
    }

    fun funWithMonitor(): Unit {
        System.out.println("锁开始了")
        synchronized(this, {
            Thread.sleep(5000)
            System.out.println("锁结束了")
        })
    }

    /**
     * 没有使用 synchronized 锁机制的，不需要等待m monitor
     */
    fun noMonitor(): Unit {
        // 无锁，不争抢。也就是还是将 变量 拷入工作内存（高速缓存）中计算
        System.out.println("不需要锁")

        // 有锁，需等待 monitor。
        synchronized(this, {
            System.out.println("不需要锁")
        })

    }
}