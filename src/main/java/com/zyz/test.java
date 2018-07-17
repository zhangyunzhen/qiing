/*
 * 文件名：test.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zyz
 * 修改时间：2018年1月10日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.zyz;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) {
/*        int a = 1;
        Integer b = new Integer(1);
        Integer c = new Integer(1);
        System.out.println("基本数据类型和包装类型比较："+(a==b));
        System.out.println("包装类和包装类==比较："+(b==c));
        System.out.println("包装类和包装类equal比较"+b.equals(c));
        System.out.println("基本数据类型和包装类比较："+(a==b.intValue()));*/

        Map<String, Object> map = new HashMap<>();
        map.put("aa", "bb");


        Object object = map.get("cc");
        String aa = String.valueOf(object);
        System.out.println(aa);
        ;
    }

    /**
     * 使用switch，一定要在case加break，不然会顺序执行下面的代码。
     */
    @Test
    public void switchTest() {
        int a = 1;
        switch (a) {
            case 0:
                System.out.println("aaa");
                break;
            case 1:
                System.out.println("bbb");
                break;
            case 2:
                System.out.println("ccc");
                break;
        }
    }


    /**
     * 在精确计算中尽量不要使用float，double浮点类型会直接计算，会损失精度
     * 应该使用bigDecimal数据类型，精确度更高（如算价等）
     */
    @Test
    public void testBigDecimal(){
        System.out.println(1.01+2.02);
        double a = 0.1;
        System.out.println(a*3);
        //bigdecimal也存在精度损失，但相比较float,double来说，精确度更高
        BigDecimal bigDecimal = new BigDecimal(0.1);
        System.out.println(bigDecimal.multiply(BigDecimal.valueOf(3)).toString());
    }
}
