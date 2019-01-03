package com.el.jichu.designpattern.templatemethod;

/**
 * @Auther: roman.zhang
 * @Date: 2019/1/3 11:32
 * @Version:V1.0
 * @Description:TestTempMethod
 * 首先将 exp 和"\\+"做参数，调用 AbstractCalculator 类里 的 calculate(String,String)方法，
 * 在 calculate(String,String)里调用同类的 split()，之后再调 用 calculate(int ,int)方法，
 * 从这个方法进入到子类中，执行完 return num1 + num2 后，将 值返回到 AbstractCalculator 类，
 * 赋给 result，打印出来。
 */
public class TestTempMethod {
    public static void main(String[] args) {
        String exp="8+8";
        AbstractCalculator plus = new Plus();
        int calculator = plus.calculator(exp, "\\+");
        System.out.println(calculator);
    }
}
