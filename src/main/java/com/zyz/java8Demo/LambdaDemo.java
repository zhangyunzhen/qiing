/*
 * 文件名：LambdaDemo.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2017年12月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz.java8Demo;

import java.util.Arrays;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 
 * Lambda表达式Demo
 * @author zhangyunzhen
 * @version 2017年12月19日
 * @see LambdaDemo
 * @since
 */
public class LambdaDemo {

    /**
     * Description: <br>
     *      接口的默认方法
     * @see
     */
    @Test
    public void testDefaultMeth(){
        DefaultMethodInterf inter = new DefauMethImp();
        inter.defaultMethod("hahha");
        inter.defaultMetho1("ccc");
    }
    /** 
     *  函数式接口（只包含一个抽象方法 ）
     * @see
     */
    @Test
    public void testLambda(){
        Runnable runnable = ()->System.out.println("aa");
        new Thread(runnable).start();
    }
    
    
    public static void main(String[] args) {
        Arrays.asList("aaa","bbb","ccc").forEach(e -> System.out.println(e+"函数式编程"));
    }
}
