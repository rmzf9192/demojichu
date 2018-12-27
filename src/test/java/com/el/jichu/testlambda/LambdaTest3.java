package com.el.jichu.testlambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest3 {
    /**
     * 断言型接口
     * Predicate<T>
     *      boolean<T t>
     */
    @Test
    public void test1(){
        List<String> list= Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
        List<String> list1 = filterStr(list, (p) -> p.length() > 3);
        for(String string:list1){
            System.out.println(string);
        }
    }
    //将满足条件的字符串添加集合中
    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> list1=new ArrayList<>();
        for(String str:list){
            if(predicate.test(str)){
                list1.add(str);
            }
        }
        return list1;
    }
    /**
     * 函数型接口
     *   Function(T,R)
     *     R apply(T var1);
     */
    @Test
    public void test2(){
        String sjjdk = functionFilter("         sjjdk           ", (str) -> str.trim());
        System.out.println(sjjdk);

        String string=functionFilter("jshhdfjsjd",(str)->str.substring(0,3));
        System.out.println(string);
    }
    //用于处理字符串
   public String functionFilter(String string, Function<String,String> function){
       return function.apply(string);
   }

    /**
     * 供给型接口Supplier
     *    T get()
     */
    @Test
    public void test3(){
        List<Integer> integers = getInteger(10, () -> {
            int random1 = (int) (Math.random()*100);
            if(random1==0){
                return 1;
            }else{
                return random1;
            }
        });
        for(Integer integer:integers){
            System.out.println(integer);
        }
        System.out.println("---------------------------------------");
        List<Integer> integer = getInteger(2, () -> (int)(Math.random() * 100));
        for(Integer in:integer){
            System.out.println(in);
        }
    }
   //产生指定个数的整数，并放到集合中
    public List<Integer> getInteger(int num, Supplier<Integer> supplier){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<num;i++){
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }

    /**
     * 消费型接口
     *  Consumer
     *     void accept(T var1);
     */
    @Test
    public void test4(){
       getString(1000,(d)-> System.out.println("哈哈哈哈，来啊"+d+"元"));
    }

    public void getString (double d, Consumer<Double> consumer){
        consumer.accept(d);
    }
}
