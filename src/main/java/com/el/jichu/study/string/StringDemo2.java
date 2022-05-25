package com.el.jichu.study.string;

import java.util.Scanner;

/**
 * <p>
 *
 * <p>
 *
 * @author Roman.Zhang
 * @date 2022/2/14
 */
public class StringDemo2 {
    public static void main(String[] args) {
        getNum();
    }

    public static void getNum(){
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        int firstLength = first.length();

        String replace = first.toLowerCase().replace(second.toLowerCase(), "");
        System.out.println(firstLength - replace.length());
    }
}
