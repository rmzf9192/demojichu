package com.el.jichu.datastructures.recursion;

/**
 * @author Roman.zhang
 * @Date: 2019/7/15 15:19
 * @Version:V1.0
 * @Description:RecursionTest 递归案例说明
 */
public class RecursionTest {
    public static void main(String[] args) {

        test(4);
        int factorial = factorial(3);
        System.out.println("阶乘的值:"+factorial);
    }

    public static void test(int n) {
        if (n > 2){
            test(n-1);
        }else{
            System.out.printf("n=%d\n",n);
        }
    }

    public static int factorial(int n ){
        if(n == 1){
            return n;
        }else{
            return factorial(n-1)*n;
        }
    }
}
