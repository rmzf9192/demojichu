package com.el.jichu.study.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *
 * <p>
 *
 * @author Roman.Zhang
 * @date 2022/2/11
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] s = sc.nextLine().split(",");
            Arrays.sort(s);
            for (int i=0;i<s.length-1;i++){
                System.out.print(s[i]+" ");
            }
            System.out.println(s[s.length-1]);
        }
    }
}
