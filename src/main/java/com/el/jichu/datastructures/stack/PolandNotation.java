package com.el.jichu.datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author Roman.zhang
 * @Date: 2019/7/12 17:03
 * @Version:V1.0
 * @Description:PolandNotation
 */
public class PolandNotation {
    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";//注意表达式
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList);
        List<String> list = parseSuffixExpressionList(infixExpressionList);

        System.out.println("后缀表达式:"+list);

        int calculate = calculate(list);
        System.out.println("calculate:"+calculate);
        /* // 逆波兰排序

        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; // 76
        List<String> list =  getStringList(suffixExpression);

        System.out.println("逆波兰排序："+list);
        int calculate = calculate(list);

        System.out.printf("值为：%d\n",calculate);*/
    }
    //即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]
    //方法：将得到的中缀表达式对应的List => 后缀表达式对应的List
    private static List<String> parseSuffixExpressionList(List<String> infixExpressionList) {
        //定义符号栈
        Stack<String> strings = new Stack<>();
        //存储中间结果
        List<String> list = new ArrayList<>();

        //遍历
        for (String item : infixExpressionList){
            if(item.matches("\\d+")){
                list.add(item);
            }else if (Objects.equals("(",item)){
                strings.push(item);
            }else if (Objects.equals(")",item)){
                while(!strings.peek().equals("(")){
                    list.add(strings.pop());
                }
                strings.pop();
            }else {
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                if (strings.size()!= 0 && Operation.getValue(strings.peek()) >= Operation.getValue(item)){
                    list.add(strings.pop());
                }
                strings.push(item);
            }
        }
        while(strings.size()!=0){
            list.add(strings.pop());
        }
        return list;
    }

    private static int calculate(List<String> list) {
        // 创建所需要的栈
        Stack<String> stringStack = new Stack<>();

        //遍历
        for(String item :list){
            //使用正则表达是判断是否为数字
            if(item.matches("\\d+")){
                stringStack.push(item);
            }else {
                int num2 = Integer.parseInt(stringStack.pop());
                int num1 = Integer.parseInt(stringStack.pop());
                int res = 0;

                if(Objects.equals(item,"+")){
                    res = num1 + num2;
                }else if(Objects.equals(item,"-")){
                    res = num1 - num2;
                }else if(Objects.equals(item,"*")){
                    res = num1 * num2;
                }else if(Objects.equals(item,"/")) {
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                stringStack.push(""+res);
            }
        }

        return Integer.parseInt(stringStack.pop());
    }

    private static List<String> getStringList(String suffixExpression) {
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele: split) {
            list.add(ele);
        }
        return list;
    }

    private static List<String> toInfixExpressionList(String s) {
        List<String> listStr = new ArrayList<>();

        int index = 0;
        String str;
        char c ;

       do {
           if((c = s.charAt(index)) < 48  || (c = s.charAt(index)) > 57){
               listStr.add(""+c);
               index ++;
           } else {
               str = "";
               if (index < s.length() && ((c = s.charAt(index)) >= 48 && (c = s.charAt(index)) <= 57)){
                   str += c;
                   index++;
               }
               listStr.add(str);
           }
       }while(index < s.length());

       return listStr;
    }


}
