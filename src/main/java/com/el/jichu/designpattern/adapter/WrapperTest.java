package com.el.jichu.designpattern.adapter;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/25 21:50
 * @Version:V1.0
 * @Description:WrapperTest4
 */
public class WrapperTest {

    public static void main(String[] args) {
        SourceSub1 sourceSub1 = new SourceSub1();
        SourceSub2 sourceSub2 = new SourceSub2();

        sourceSub1.method1();
        sourceSub1.method2();

        sourceSub2.method1();
        sourceSub2.method2();

    }
}
