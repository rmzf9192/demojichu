package com.el.jichu.algorithm.kmp;

/**
 * @author Roman.zhang
 * @Date: 2019/7/31 11:54
 * @Version:V1.0
 * @Description:ViolenceMatch
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        //测试暴力匹配算法
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅谷你";
        int index = violenceMatch(str1, str2);
        System.out.println("index=" + index);
    }

    /**
     * 暴力匹配
     * @param str1
     * @param str2
     */
    public static int violenceMatch(String str1,String str2){

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;
        //i索引指向s1;
        int i = 0;
        //j索引指向s2;
        int j = 0;
        while(i < s1Len && j < s2Len){

            if(s1[i] == s2[j]){
                //匹配成功
                i++;
                j++;
            }else{
                //匹配失败
                i = i - (j-1);
                j = 0;
            }
        }
        //判断是否成功
        if(j == s2Len){
            return i - j;
        }else{
            return -1;
        }
    }
}
