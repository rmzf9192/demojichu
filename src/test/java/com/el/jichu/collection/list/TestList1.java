package com.el.jichu.collection.list;

import com.el.jichu.designpattern.adapter.test.Source;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author roman.zhang
 * @Date: 2019/9/26 14:44
 * @Version:V1.0
 * @Description:TestList
 */
@Slf4j
public class TestList1 {

    @Test
    public void testArrayList(){
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("10");

        arrayList.add("11");

//        arrayList.remove(0);
        arrayList.add("11");

        Iterator iterator = arrayList.iterator();

        for (int i = 0; arrayList.iterator().hasNext(); i++) {
            arrayList.remove(i);
            System.out.println(arrayList.get(i));
        }

        while(iterator.hasNext()){
            Object next = iterator.next();
            iterator.remove();
            System.out.println("next:"+next);
        }
        System.out.println("=====");
        for (Object str: arrayList) {
            arrayList.remove(1);
            System.out.println(str);
        }
        Object o = arrayList.get(1);
       /* arrayList.parallelStream().forEach(item->{
            System.out.println(item);
        });

        arrayList.trimToSize();

        arrayList.ensureCapacity(1);

        int[] src = {1,2,3,4,5,6,7,8,9};

        int[] des = new int[5];

        System.arraycopy(src,0,des,0,5);

        Arrays.stream(des).forEach(item -> System.out.println(item));

        System.out.println("+++++++++++++++++++++++++++++");

        Arrays.stream(src).forEach(item -> System.out.println(item));*/

    }


    @Test
    public void testLinkedList(){
        LinkedList linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add("jjj");
        linkedList.addAll(Arrays.asList("aaa"));
        linkedList.add("aaa");

        linkedList.remove("aaa");
        linkedList.get(2);


        ListIterator listIterator = linkedList.listIterator(1);
        System.out.println(listIterator.hasPrevious());
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        Iterator iterator = linkedList.descendingIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.hasNext());
        }
    }

    @Test
    public void testVector(){
        Vector vector = new Vector();

        CopyOnWriteArrayList syncList = new CopyOnWriteArrayList();

        syncList.add(1);
        syncList.add(2);
        syncList.add(3);

        Iterator iterator = syncList.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
            syncList.add(4);
        }
        Iterator iterator1 = syncList.iterator();

        System.out.println("=====================");

        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

    @Test
    public void test10(){
        val bigDecimals = new ArrayList<BigDecimal>();
        bigDecimals.add(BigDecimal.valueOf(2));
        bigDecimals.add(BigDecimal.valueOf(2));
        bigDecimals.add(BigDecimal.valueOf(2));
//        val result = getResult1(bigDecimals,new BigDecimal(1));
        val result = getResult(bigDecimals);

        System.out.println("计算结果 ："+result);
    }

    private BigDecimal getResult(List<BigDecimal> lists){
        val iterator = lists.listIterator();
        BigDecimal init = new BigDecimal(1);
        BigDecimal total = new BigDecimal(1);
        while(iterator.hasNext()){
            total = total.multiply(init.add(iterator.next()));
        }
        return total;
    }

    private BigDecimal getResult1(List<BigDecimal> lists,BigDecimal total){
        val iterator = lists.listIterator();
        BigDecimal init = new BigDecimal(1);
        if(iterator.hasNext()){
            total = total.multiply(init.add(iterator.next()));
            iterator.remove();
            return getResult1(lists,total);
        }
        return total;
    }

    @Test
    public void test11(){
        StringBuffer head = new StringBuffer("P");
        val yyyymmdd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        val now = LocalDateTime.now();
        val format = yyyymmdd.format(now);

        System.out.printf("流水号： "+res(3));
        System.out.printf("流水号： "+head+format);
    }

    private StringBuffer res(int number){
        Random rand = new Random(); //创建一个新随机数生成器
        StringBuffer stringBuffer = new StringBuffer();   //创建一个7位的数组,主要是保存结果，我需要7个不重复的随机值
        boolean[] bool = new boolean[number + 1];
        int randint = 0;
        for (int i = 0; i < number; i++) {
            do {
                randint = rand.nextInt(number) + 1;
            } while (bool[randint]);
            bool[randint] = true;   //状态设置为true
            stringBuffer=stringBuffer.append(randint);
        }

        return stringBuffer;
    }

    @Test
    public void test12(){
        List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sd", "mvkd");
        list.stream().forEach(e ->{
            if(e.length() >= 5){
                System.out.println(e);
                return;
            }
            System.out.println(e);
        });
    }

    @Test
    public void test13(){
        final val strings = new ArrayList<String>();
        strings.stream().forEach((v)-> System.out.println(v));

        final val bigDecimals = new ArrayList<BigDecimal>();
        bigDecimals.add(new BigDecimal(0.5));
        bigDecimals.add(new BigDecimal(0.11));

        final val addRecursion = getAddRecursion(bigDecimals, new BigDecimal(1));
        System.out.println("result:"+BigDecimal.valueOf(13).multiply(addRecursion));
//                addRecursion.setScale(2,BigDecimal.ROUND_HALF_UP));
    }

    private BigDecimal getAddRecursion(List<BigDecimal> lists,BigDecimal total){
        val iterator = lists.listIterator();
        if(iterator.hasNext()){
            total = total.add(iterator.next());
            iterator.remove();
            return getAddRecursion(lists,total);
        }
        return total;
    }
}
