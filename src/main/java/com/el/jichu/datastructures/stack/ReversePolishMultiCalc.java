package com.el.jichu.datastructures.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author Roman.zhang
 * @Date: 2019/7/15 13:52
 * @Version:V1.0
 * @Description:ReversePolishMultiCalc 逆波兰表达是完整版
 */
public class ReversePolishMultiCalc {
    /**
     * 匹配+-/*（）运算符
     */
    static final String SYMBOL = "\\+|-|\\*|/|\\(|\\)";

    static final String LEFT ="(";
    static final String RIGHT =")";
    static final String ADD="+";
    static final String MINUS="-";
    static final String TIMES="*";
    static final String DIVISION="/";

    /**
     * 加减+-
     */
    static final int  LEVEL_01 = 1;

    static final int LEVEL_02 = 2;

    /**
     * 括号
     */
    static final int LEVEL_HIGH = Integer.MAX_VALUE;

    static Stack<String> stack = new Stack<>();

    static List<String> data = Collections.synchronizedList(new ArrayList<>());

    /**
     * 去除所有空白
     * @param s
     * @return
     */
    public static String replaceAllBlank(String s){
        return s.replaceAll("\\s+","");
    }

    /**
     * 判断是否是数字
     * @param s
     * @return
     */
    public static boolean isNumber(String s){
        String regex="^[-\\+]?[.\\d]*$";
        Pattern compile = Pattern.compile(regex);
        return compile.matcher(s).matches();
    }

    /**
     * 判断是否是运算符
     * @param s
     * @return
     */
    public static boolean isSymbol(String s){
        return s.matches(SYMBOL);
    }

    /**
     * 匹配运算符等级
     * @param s
     * @return
     */
    public static int calLevel(String s){
        if("+".equals(s)||"-".equals(s)){
            return LEVEL_01;
        }else if("*".equals(s) || "/".equals(s)){
            return LEVEL_02;
        }
        return LEVEL_HIGH;
    }

    public static List<String> doMatch(String s){
        if(null == s || "".equals(s.trim()))throw  new RuntimeException("data is empty");

        if(!isNumber(s.charAt(0)+""))throw new RuntimeException("data illeagle,start not with a number");

        s = replaceAllBlank(s);
        String each;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if(isSymbol(s.charAt(i)+"")){
                each = s.charAt(i)+"";
                //栈为空（操作符，或者操作符优先级大于栈顶优先级 &&
                // 操作符优先级不是（）的优先级及是）不能直接入栈）

                if(stack.isEmpty() || LEFT.equals(each)||((calLevel(each)>calLevel(stack.peek())))
                        &&calLevel(each) < LEVEL_HIGH){
                    stack.push(each);
                }else if (!stack.isEmpty() && calLevel(each) <= calLevel(stack.peek())){
                    //栈非空，操作符优先级小于等于栈顶优先级时出栈，知道栈为空，或者遇到了( ,最后操作符入栈

                    while(!stack.isEmpty() && calLevel(each) <= calLevel(stack.peek())){
                        if(calLevel(each) == LEVEL_HIGH){
                            break;
                        }
                        data.add(stack.pop());
                    }
                    stack.push(each);
                }else if(RIGHT.equals(each)) {
                    // )操作符，依次出栈入列知道空栈或者遇到了第一个）操作符，此时）出栈
                    while(!stack.isEmpty() && LEVEL_HIGH >= calLevel(stack.peek())){
                        if(LEVEL_HIGH == calLevel(stack.peek())){
                            stack.pop();
                            break;
                        }
                        data.add(stack.pop());
                    }
                }
                start = i ;  //前一个运算符的位置
            }else if (i == s.length()-1 || isSymbol(s.charAt(i+1)+"")){
                each = start == 0 ? s.substring(start,i+1):s.substring(start+1,i+1);

                if(isNumber(each)){
                    data.add(each);
                    continue;
                }
                throw new RuntimeException("data not match number");
            }
        }
        //如果栈里还有元素，此时元素需要依次出栈入列，可以想象栈里剩下栈顶为/,栈低为+，应该依次出栈入列，可以直接翻转整个stack
        //添加到队列
        Collections.reverse(stack);
        data.addAll(new ArrayList<>(stack));

        System.out.println(data);
        return data;
    }

    /**
     * 算出结果
     * @param list
     * @return
     */
    public static Double doCale(List<String> list){
        Double d = 0d;

        if (list == null || list.isEmpty()){
            return null;
        }

        if(list.size() == 1){
            System.out.println(list);
            d = Double.valueOf(list.get(0));
            return d;
        }

        ArrayList<String> list1 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i));

            if(isSymbol(list.get(i))){
                Double d1 = doTheMath(list.get(i-2),list.get(i-1),list.get(i));

                list1.remove(i);
                list1.remove(i-1);
                list.set(i-2,d1+"");
                list.addAll(list.subList(i+1,list.size()));
                break;
            }
        }
        doCale(list1);
        return d;
    }

    public static Double doTheMath(String s1,String s2,String symbol){
        Double result;

        switch (symbol){
            case ADD :result = Double.valueOf(s1) + Double.valueOf(s2);break;
            case MINUS :result = Double.valueOf(s1) - Double.valueOf(s2);break;
            case TIMES :result = Double.valueOf(s1) * Double.valueOf(s2);break;
            case DIVISION :result = Double.valueOf(s1) / Double.valueOf(s2);break;
            default:result =null;
        }
        return result;
    }

    public static void main(String[] args) {
       // String math = "12.8 + (2-3.55)*4+10/5.0";
        String math = "9+1";

        Double aDouble = doCale(doMatch(math));

        System.out.println("计算的值为："+aDouble);
    }
}

