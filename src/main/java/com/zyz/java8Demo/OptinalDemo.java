package com.zyz.java8Demo;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 11:17 2018/9/7
 */
public class OptinalDemo {


    @Test
    public void test(){
        String s = Optional.of("aasd").map(p -> p.replaceAll("a", "d")).orElse("11111");
        System.out.println(s);
    }
}
