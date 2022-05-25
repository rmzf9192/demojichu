package com.el.jichu.datastructures;

import java.util.Scanner;

/**
 * @author Roman.zhang
 * @Date: 2019/7/18 9:49
 * @Version:V1.0
 * @Description:HashTabDemo 哈希表实现快速查找功能
 */
public class HashTabDemo {
    public static void main(String[] args) {

        //创建HastTable
        HashTable hashTable = new HashTable(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();

            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    int empId = scanner.nextInt();
                    hashTable.findEmpById(empId);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }
}

/**
 * 创建HastTable管理链表
 */
class HashTable{
    private EmpLinkedList[] empLinkedLists;

    private int size;

    public HashTable(int size) {
        this.size = size;
        //初始化链表
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     * @param emp
     */
    public void add(Emp emp){
        //根据员工id，判断添加到那个链表
        int hashEmp = hashFun(emp.id);
        empLinkedLists[hashEmp].add(emp);
    }

    /**
     * 遍历所有雇员
     */
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    /**
     * 根据id查找雇员
     * @param id
     * @return
     */
    public void findEmpById(int id){
        //使用散列函数，判断雇员在那个链表上
        int hashEmp = hashFun(id);
        Emp emp = empLinkedLists[hashEmp].findEmpById(id);

        if(null != emp){
            System.out.printf("找到第%d链条中找到 雇员 id = %d\n ",(hashEmp+1),id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }
    //编写散列函数, 使用一个简单取模法 
    public int hashFun(int id) {
        return id % size;
    }
}
/**
 * 表示雇员
 */
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

/**
 * 创建链表
 */
class EmpLinkedList{
    //首先指定第一个雇员
    private Emp head;

    /**
     * 添加雇员：
     *    假定雇员的id是逐步递增的，因此，每次添加雇员都是添加到最后
     * @param emp
     */
    public void add(Emp emp){
        //添加第一个雇员
        if(null == head){
            head = emp;
            return;
        }

        Emp curEmp = head;
        while(true){
            //说明指定到最后的位置
            if(null == curEmp.next){
                break;
            }
            // 后移
            curEmp = curEmp.next;
        }
        //将对应的雇员加上去
        curEmp.next = emp;
    }

    /**
     * 遍历雇员信息
     * @param no
     */
    public void list(int no){
        if(null == head){
            System.out.println("第"+(no+1)+"雇员信息 链表为空");
            return;
        }
        System.out.print("第 "+(no+1)+" 链表的信息为");
        Emp curEmp = head;
        while(true){
            System.out.printf("=> id =%d name=%s\t",curEmp.id,curEmp.name);
            if(null == curEmp.next){
                break;
            }
            //后移
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    /**
     * 根据雇员ID查找雇员
     * @param id
     * @return
     */
    public Emp findEmpById(int id){
        if(null == head){
            System.out.println("链表为空");
            return null;
        }

        Emp curEmp = head;

        while(true) {
            //找到雇员
            if(id == curEmp.id){
                System.out.println("找到雇员id为"+curEmp.id);
                break;
            }
            //没有找到雇员
            if(null == curEmp.next){
                curEmp = null;
                break;
            }
            //后移
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
