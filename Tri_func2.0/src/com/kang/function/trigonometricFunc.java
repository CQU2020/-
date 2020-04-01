package com.kang.function;

/**
 * 使用泰勒公式实现三角函数
 */

public class trigonometricFunc {
    double x;

    public trigonometricFunc(double x) {
        this.x = x;
    }

    public trigonometricFunc() {
    }

    /**
     * sinx的泰勒公式为： sin(x) = x - x^3/3! + x^5/5! - x^7/7! + ...
     * @param x
     * @return
     */
    public double sin(double x){
        // 求和
        double term = 1.0;
        double sum = 0.0;
        // 泰勒公式
        for (int i = 1; term != 0.0; i++) {
            term *= (x / i);
            if (i % 4 == 1) {
                sum += term;
            } else if (i % 4 == 3) {
                sum -= term;
            }
        }
        return sum;
    }

    /**
     * cos(x) = 1 − x^2/2! + x^4/4! − x^6/6!+ …
     * @param x
     * @return
     */
    public double cos(double x){
        double term = 1.0;
        double sum = 1.0;
        for(int i = 1; term != 0; i++){
            term  *= (x / i);
            if(i % 4 == 0){
                sum += term;
            }else if(i % 4 == 2){
                sum -= term;
            }
        }
        return sum;
    }

    /**
     * 计算tan
     */
    public double tan(double x){
        return sin(x) / cos(x);
    }

    /**
     * 计算cot
     */
    public double cot(double x){
        return cos(x) / sin(x);
    }
}
