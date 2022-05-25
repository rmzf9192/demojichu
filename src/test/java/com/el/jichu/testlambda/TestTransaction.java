package com.el.jichu.testlambda;

import com.el.jichu.domain.Trader;
import com.el.jichu.domain.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTransaction {

    List<Transaction> transactions = null;

    @Before
    public void beforeTest() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

    }

    @Test
    public void test1() {
        //查找2011年份的交易额，并按照从低到高的顺序排序
        transactions.stream()
                .filter((e) -> e.getYear() == 2011)
                .sorted((x, y) -> -Integer.compare(x.getValue(), y.getValue()))
                .forEach(System.out::println);
        System.out.println("--交易员在那些不同的的城市工作的--");
        //交易员在那些不同的的城市工作的
        transactions.stream()
                .map((e) -> e.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("查找来自剑桥的交易员并按照姓名排序");
        transactions.stream()
                .filter((e) -> ("Cambridge").equals(e.getTrader().getCity()))
                .map((e) -> e.getTrader())
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .distinct()
                .forEach(System.out::println);
    }

    //返回所有交易员的姓名字符串，并按照字母排序
    @Test
    public void test2() {
        transactions.stream()
                .map((t) -> t.getTrader().getName())
                .sorted()
                .distinct()
                .forEach(System.out::println);
        System.out.println("------------------------");

        transactions.stream()
                .map((t) -> t.getTrader().getName())
                .sorted()
                .reduce("", String::concat);
        System.out.println("-----------------------");

        transactions.stream()
                .map((t) -> t.getTrader().getName())
                .flatMap(TestTransaction::filterString)
                .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                .forEach(System.out::println);
    }

    public static Stream<String> filterString(String str) {
        List<String> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c.toString());
        }
        return list.stream();
    }

    @Test
    public void test3() {
        //有没有交易员在米兰工作
        boolean b = transactions.stream()
                .anyMatch((t) -> ("Milan").equals(t.getTrader().getCity()));
        System.out.println("有没有交易员在米兰工作:" + b);

        //打印所有在剑桥的交易员的消费额
        Optional<Integer> reduce = transactions.stream()
                .filter((t) -> ("Cambridge").equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println("打印所有在剑桥的交易员的消费额:" + reduce.get());

        //查找所有交易饿最高的信息
        Optional<Integer> max = transactions.stream()
                .map((e) -> e.getValue())
                .max(Integer::compare);
        Stream<Transaction> transactionStream = transactions.stream()
                .filter((e) -> e.getValue() == max.get());

        List<Transaction> collect = transactionStream.collect(Collectors.toList());
        for (Transaction transaction : collect) {
            System.out.println(transaction);
        }


        System.out.println("查找所有交易饿最高的信息:" + max.get());

        //找到交易额最小的交易记录
        Optional<Integer> min = transactions.stream()
                .map((e) -> e.getValue())
                .min(Integer::compare);

        System.out.println("找到交易额最小的交易记录:" + min.get());
        Optional<Transaction> min1 = transactions.stream()
                .min((x, y) -> Integer.compare(x.getValue(), y.getValue()));
        Transaction transaction = min1.get();

        System.out.println(min1.get());

    }

}
