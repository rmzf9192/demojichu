package com.el.jichu.algorithm.dac;

/**
 * @author Roman.zhang
 * @Date: 2019/7/31 9:59
 * @Version:V1.0
 * @Description:Hanoitower
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    /**
     * 分治算法：汉诺塔
     * @param num 盘数
     * @param a
     * @param b
     * @param c
     */
    public static void hanoiTower(int num,char a,char b,char c){
        if(1==num){
            System.out.println("第1个盘从"+a+"->"+c);
        }else{
            //如果是num >= 2我们总是看成俩个盘 1:最下面的盘，2:上面所有的盘
            //先把上面的盘从A->B,移动过程中要使用到c
            hanoiTower(num - 1,a,c,b);

            //2.把最下面的盘A->C
            System.out.println("第"+num+"盘从"+a+"->"+c);

            //3.把B上面的盘，移到C
            hanoiTower(num-1,b,a,c);
        }


    }
}
