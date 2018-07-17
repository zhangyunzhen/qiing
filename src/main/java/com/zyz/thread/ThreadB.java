package com.zyz.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: YunzhenZhang
 * @Description:
 *          创建线程的第三种方式：
 *              实现Callable接口
 * @Date: Created in 11:27 2018/7/15
 */
public class ThreadB {


   static class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println("i'm call"+Thread.currentThread().getName());
            return "call return";
        }
    }

    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> ft = new FutureTask<String>(myCallable);
        Thread thread = new Thread(ft);
        thread.start();
    }
}
