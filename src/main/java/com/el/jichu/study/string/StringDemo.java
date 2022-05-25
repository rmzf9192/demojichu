package com.el.jichu.study.string;

import lombok.var;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *  根据输入的单词，获取最后一个单词的长度
 * <p>
 *
 * @author Roman.Zhang
 * @date 2022/2/10
 */
public class StringDemo {
    public static void main(String[] args) {
        System.out.println(getLength());
    }

    //倒序遍历字符串
    public static int getLength2(){
        var scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int length = 0;
        for (int i = str.length() - 1; i < str.length(); i--) {
            if(str.charAt(i) == ' '){ //if (str.substring(i, i + 1).equals(" ")) {
                break;
            }
            length ++ ;
        }
        return length;
    }
    //根据系统函数
    public static int getLength1(){
        var scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] split = str.split("\\s+");
        int length = split[split.length - 1].length();
        return length;
    }

    public static int getLength3(){
        var scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int length = str.length();
        int i = str.lastIndexOf(' ');
        length = length - (i+1);
        return length;
    }

    public static int getLength(){
        var scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String[] s = str.split(" ");
        AtomicInteger i = new AtomicInteger();
        Arrays.stream(s).forEach(v->{
            i.getAndIncrement();
        });
        int i1 = i.decrementAndGet();
        int length = s[i1 - 1].length();
        return length;
    }

}
