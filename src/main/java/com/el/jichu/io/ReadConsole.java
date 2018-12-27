package com.el.jichu.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {
    public static void main(String[] args) throws Exception{
        String s;
        char c;
        int b;
        b='A';
        System.out.print(b+"   cccc");
        System.out.write(b);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("输入字符串'P'终止");
        do{
             c= (char) bufferedReader.read();
            s = bufferedReader.readLine();
            System.out.println(s);
        }while (!"P".equalsIgnoreCase(s));
    }
}
