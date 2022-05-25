package com.el.jichu.algorithm.kmp;

import java.util.Arrays;

/**
 * @author Roman.zhang
 * @Date: 2019/7/31 14:27
 * @Version:V1.0
 * @Description:KMPAlgorithm
 */
public class  KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        //String str2 = "BBC";
        int[] next = kmpNext("ABCDABD");
        //[0, 1, 2, 0]
        System.out.println("next=" + Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index); // 15了
    }

    /**
     * KMP算法
     * @param str1 源字符串
     * @param str2 目标字符串
     * @param next 部分匹配表
     * @return 索引，没找到返回-1
     */
    public static int kmpSearch(String str1,String str2,int[] next){
        for (int i = 0,j = 0; i < str1.length(); i++) {
            while(j  > 0 && str1.charAt(i)!= str2.charAt(j)){
                j = next[j-1];
            }

            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(j == str2.length()){
                //说明找到了
                return i - j +1;
            }
        }
        return -1;
    }


    /**
     * 获取一个字符串的部分匹配值表
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest){
        //创建一个数组保存部分匹配值 "ABCDABD"
        int[] next = new int[dest.length()];
        //字符串长度为1，部分匹配表就是0；
        next[0] = 0;
        for (int i = 1,j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j),需要从j = next[j-1]赋值
            // 当dest.chartAt(i) == dest.charAt(j)成功退出
            while(j > 0 && dest.charAt(i)!= dest.charAt(j)){
                j = next[j-1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }

        return next;
    }
}
