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

import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

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
    public void testBigDecimal() {
        System.out.println(1.01 + 2.02);
        double a = 0.1;
        System.out.println(a * 3);
        //bigdecimal也存在精度损失，但相比较float,double来说，精确度更高
        BigDecimal bigDecimal = new BigDecimal(0.1);
        System.out.println(bigDecimal.multiply(BigDecimal.valueOf(3)).toString());
    }

    /**
     * 将方法参数定义为final类型，标识该参数内存地址不可变，但值可以变(指对象)
     * 常量的值在编译期间就已经确定了。
     */
    @Test
    public void testFinal() {
        Map<String, String> map = Maps.newHashMap();
        String aa = testFianl(map, "aa");
        System.out.println(map.get("aa"));
        System.out.println(aa);
    }

    public String testFianl(final Map<String, String> map, final String aa) {
        map.put("aa", "aaa");
        //aa = "bb";    编译会不通过
        return aa;
    }


    @Test
    public void testRandom() {
        Random random = new Random();
        ;
        int i = random.nextInt(2);
        System.out.println(i);
    }

    @Test
    public void dataTest() throws ParseException {
        long time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("1970-01-01 08:00:00").getTime();
        System.out.println(time);
    }

    /**
     * 正则表达式匹配
     * .  匹配除换行符 (\n)之外的任意字符
     * [] 匹配一个字符列表
     * * 匹配零次或多次前面的字符
     * + 匹配一次或多次前面的字符
     */
    @Test
    public void testRegular() {
        String str = "asdasd123ASD";
        System.out.println(".匹配字符==" + str.replaceAll("a.d", "-"));
        System.out.println("[]匹配一个字符列表==" + str.replaceAll("[ad]", "-"));
        System.out.println("[]匹配一个字符列表(a到c)==" + str.replaceAll("[a-c]", "-"));
        System.out.println("[]匹配一个字符列表(除了a-c)==" + str.replaceAll("[^a-c]", "-"));


        //匹配3-7位 包含数字和大写字母的字符串
        String pattern = "^(?![0-9]+$)(?![A-Z]+$)[0-9A-Z]{3,7}$";
        //匹配13位纯数字
        String pattern1 = "^[0-9]{13}$";
        //匹配时间yyyy-mm-dd
        String pattern2 = "((((19|20)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((19|20)\\d{2})-(0?[469]|11)-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-(0?[1-9]|[12]\\d)))$";

        System.out.println(Pattern.matches(pattern2, "2010-11-11"));
    }


    @Test
    public void test() {
  /*      System.out.println(CharMatcher.DIGIT.retainFrom("0S"));
        System.out.println(CharMatcher.DIGIT.retainFrom("S"));
        System.out.println(  CharMatcher.DIGIT.removeFrom("S"));*/

        ArrayList<String> strings = Lists.newArrayList("1", "2", "3");
        List<String> list = strings.subList(0, 5);
    }


}
