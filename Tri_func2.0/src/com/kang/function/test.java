package com.kang.function;

import java.util.Map;

public class test {
    public static void main(String[] args) {
        trigonometricFunc tri = new trigonometricFunc();

        double cos1 = tri.cos(3.3);
        System.out.println("使用泰勒公式计算的cos函数");
        System.out.println(cos1);
        System.out.println("使用系统自带的cos函数");
        System.out.println(Math.cos(3.3));
    }
}
