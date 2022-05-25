package com.el.jichu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * <p>
 *
 * @author Roman.Zhang
 * @date 2021/4/29
 */
public class UnmodifiedMapDemo {
    private Map<String,Person1> personMap;

    public UnmodifiedMapDemo(){
        this.personMap = new HashMap();
        personMap.put("3",new Person1(3,"lr"));
    }

    public Map getPersonMap() {
        return Collections.unmodifiableMap(this.personMap);
    }

    public void setPersonMap(Map personMap) {
        this.personMap = personMap;
    }

    public void changeMap(){
        personMap.put("4",new Person1(4,"testChange"));
    }

    public void printMap(){
        System.out.println("******");
        System.out.println("类中原始的map");
        for(String key:personMap.keySet()){
            System.out.println(personMap.get(key));
        }
    }

    public static  void main(String[] args){
        UnmodifiedMapDemo test = new UnmodifiedMapDemo();
        Map<String,Person1> umMap = test.getPersonMap();

        System.out.println("******");
        System.out.println("最原始的数据");
        for(String key:umMap.keySet()){
            System.out.println(umMap.get(key));
        }

        //修改map中的对象
        Person1 person = umMap.get("3");
        person.setAge(55);

        test.changeMap();

        System.out.println("******");
        System.out.println("修改后的数据");
        for(String key:umMap.keySet()){
            System.out.println(umMap.get(key));
        }
        try {
            umMap.put("5",new Person1(11,"testAdd"));
        }catch (UnsupportedOperationException e){
            System.out.println("操作被拒绝");
        }

        test.printMap();


    }

}


 class Person1 {
    private int age;
    private String name;

    public Person1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
