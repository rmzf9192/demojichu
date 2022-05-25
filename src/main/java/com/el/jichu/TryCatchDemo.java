package com.el.jichu;

import com.el.jichu.domain.Trader;
import com.el.jichu.sort.DemoDO;
import lombok.val;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 功能说明
 * </p >
 *
 * @author Roman.Zhang
 * @date 2020/11/6
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        final val traders = new ArrayList<Trader>();
        final val trader = new Trader();
        trader.setCity("AUTO");
        trader.setName("张1");
        trader.setRoId(100L);
        trader.setAge(14L);
        traders.add(trader);
        final val trader3 = new Trader();
        trader3.setCity("AUTO");
        trader3.setRoId(110L);
        trader3.setName("姓名2");
        trader3.setAge(13L);
        traders.add(trader3);
        final val trader1 = new Trader();
        trader1.setCity("MANU");
        trader1.setName("姓名2");
        trader1.setRoId(110L);
        trader1.setAge(13L);
        traders.add(trader1);

         val comparing = Comparator.comparing(Trader::getCity);
         val comparing1 = Comparator.comparing(Trader::getRoId).reversed();
         val comparing2 = Comparator.comparing(Trader::getAge).reversed();
        Collections.sort(traders,comparing.thenComparing(comparing1.thenComparing(comparing2)));

        final val trader2 = new Trader();
        trader2.setCity(null);
        trader2.setName("姓名3");
        traders.add(trader2);
        final val collect = traders.stream().collect
                (Collectors.groupingBy(x-> Optional.ofNullable(x.getCity())));
        collect.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
        list().stream().forEach(v->System.out.println(v));
        final val now = LocalDateTime.now();
        System.out.println(now.getMonthValue());



    }

    public static List<Long> list(){
        final val longs = new ArrayList<Long>();
        final val doubleArrayList = new ArrayList<DemoDO>();
        final val demoDO = new DemoDO();
        demoDO.setI(1);
        demoDO.setName("测试1");
        doubleArrayList.add(demoDO);
        final val demoDO2 = new DemoDO();
        demoDO2.setI(2);
        demoDO2.setName("测试2");
        doubleArrayList.add(demoDO2);
        final val demoDO3 = new DemoDO();
        demoDO3.setI(3);
        demoDO3.setName("测试1");
        doubleArrayList.add(demoDO3);

        Collections.sort(doubleArrayList, Collections.reverseOrder((v1,v2)->v1.getI()- v2.getI()));
        doubleArrayList.forEach(v->{
            System.out.println(v.getI()+":"+v.getName());
        });
        System.out.println("测试测试");
        StringBuilder htmlHead = new StringBuilder();

        try {
            String message = " 订单号 \t 客户订单编号 \t 执行情况 \t 错误信息 \t \n\t";
            htmlHead.append(message);
            htmlHead.append("测试" +"\t"+
                    "测试1"+"\t"+
                    "测试2"+"\t"+
                    "测试3"+"\t \n\t");
            System.out.println(htmlHead);
            longs.add(100L);
            int i = 10;
            int j = 0;
            int m = i/j;
        } catch (Exception e) {
            e.printStackTrace();
            longs.add(200L);
//           return longs;
        }
//        longs.add(400L);
//        return longs;
        return longs;
    }
}
