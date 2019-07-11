package com.el.jichu.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/15 14:00
 * @Version:V1.0
 * @Description:TestAnnotation
 */
public class TestAnnotation {
   static Annotation[] annotations=null;

   public void failFast(){
       // 使用ImmutableList初始化一个List
       List<String> userNames = new ArrayList<String>() {{
           add("Hollis");
           add("hollis");
           add("HollisChuang");
           add("H");
       }};

       Iterator iterator = userNames.iterator();
       do
       {
           if(!iterator.hasNext())
               break;
           String userName = (String)iterator.next();
           if(userName.equals("Hollis"))
               userNames.remove(userName);
       } while(true);
       System.out.println(userNames);
   }

    public static void main(String[] args) throws ClassNotFoundException {
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis2");
            add("hollis1");
            add("HollisChuang");
            add("H");
        }};

        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName);
            }
        }
        System.out.println(userNames);
/**
 * java.util.ConcurrentModificationException
 * 之所以会出现这个异常，是因为触发了一个Java集合的错误检测机制——fail-fast 。
 */

        getAnnotation();
    }

    private static void getAnnotation() throws ClassNotFoundException {
        //静态加载类
        Class<?> cla = Class.forName("com.el.jichu.annotation.Student");

        //判断该类是否加了注解
        boolean b = cla.isAnnotationPresent(MyAnnotation.class);
        if(b){
            //获取注解
            annotations = cla.getAnnotations();
            //使用Stream遍历
            Arrays.asList(annotations).stream().forEach((x)->{
                MyAnnotation myAnnotation= (MyAnnotation) x;
                System.out.println("name:"+myAnnotation.name()+",say:"+myAnnotation.say()+",age:"+myAnnotation.age());
            });
        }
        System.out.println("=========下面是方法========");
        Method[] methods = cla.getMethods();



        Arrays.asList(methods).stream().forEach((x)->{
            boolean b1 = x.isAnnotationPresent(MyAnnotation.class);
            if(b1){
                Annotation[] annotations = x.getAnnotations();
                Arrays.asList(annotations).stream().forEach((a)->{
                    MyAnnotation myAnnotation= (MyAnnotation) a;
                    System.out.println("name:"+myAnnotation.name()+",say:"+myAnnotation.say()+",age:"+myAnnotation.age());
                });
            }
        });

        System.out.println("get field before");

        Field[] field = cla.getDeclaredFields();

        Arrays.asList(field).stream().forEach((f)->{
            f.setAccessible(true);
            System.out.println(f.getName());
        });

        System.out.println("get student interfaces ");

        Class<?>[] interfaces = cla.getInterfaces();

        Arrays.asList(interfaces).stream().forEach((i)->{
            Method[] methods1 = i.getMethods();
            Arrays.asList(methods1).stream().forEach((f)->{
                System.out.println(f.getName());
            });
        });
    }

}
