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
        
        Map<String, Object> map =new HashMap<>();
        map.put("aa","bb");
        
        
        Object object = map.get("cc");
       String aa = String.valueOf(object);
       System.out.println(aa);;
    }

}
