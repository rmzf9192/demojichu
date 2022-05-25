package com.el.jichu.designpattern.adapter;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/25 21:14
 * @Version:V1.0
 * @Description:AdapterTest
 */
public class AdapterTest {

    public static void main(String[] args) {

      //类的适配器
      Targetable adapter= new Adapter();
      adapter.method1();
      adapter.method2();

        //对象适配器
        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method2();
    }

}
