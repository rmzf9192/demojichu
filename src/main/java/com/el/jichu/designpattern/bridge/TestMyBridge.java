package com.el.jichu.designpattern.bridge;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/28 9:09
 * @Version:V1.0
 * @Description:TestMyBridge:桥接模式
 */
public class TestMyBridge {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();
        //调用第一个对象
        Sourceable sourceSub1 = new SourceSub1();
        bridge.setSourceable(sourceSub1);
        bridge.method();

        //调用第二个对象
        Sourceable sourceSub2 = new SourceSub2();
        bridge.setSourceable(sourceSub2);
        bridge.method();
    }
}
