package com.el.jichu;

import java.util.ArrayList;

/**
 * <p>
 *
 * <p>
 *
 * @author Roman.Zhang
 * @date 2021/6/17
 */
public class TryDemo {
    //    public static void main(String[] args) {
//        try {
//            System.out.println(work());
//        } catch (Exception e) {
//            //捕获不到异常
//            e.printStackTrace();
//        }
//    }
//
//
//    public static int work() {
//        int c = 0;
//        try {
//            c = 3 / 0;
//            return 4;
//        } catch (Exception e) {
//            //除以0 ，会有异常:ArithmeticException: / by zero
//            throw e;
//        } finally {
//            return c;
//        }
//    }
//}
    public static void main(String[] args) {
        System.out.println(work());
        ArrayList<Long> longs = new ArrayList<>();
        longs.add(1L);
        longs.add(2L);
        longs.add(3L);
        ArrayList<Long> longs1 = new ArrayList<>();
        longs1.add(5L);
        longs1.add(6L);
        longs1.add(7L);
         longs.retainAll(longs1);
longs.stream().forEach((v)->{
    System.out.println(v);
});
//        final String s1 = "a";
//        final String s2 = "b";
//        String s3 = "ab";
//        String s4 = s1 + s2;
//        System.out.println(s3 == s4);//true
    }


    public static int work() {
        int x = 3;
        try {
//           int j = x/0;
            return x;
        } catch (Exception e) {
            x= 6;
//           System.out.println(x);
            e.printStackTrace();
//            return x;
        } finally {
            x = 5;
//            System.out.println(x);
            return x;
        }
//        return x;
    }
}
