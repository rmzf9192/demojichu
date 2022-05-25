package com.el.jichu.jvm;

/**
 * @author Roman.Zhang
 * @date 2020/4/15
 * @description:
 *   获取对应的类加载器
 *
 *   从下面的结果可以看出，并没有获取到ExtClassLoader的父Loader，
 *   原因是Bootstrap Loader（引导类加载器）是用C语言实现的，找不到一个确定的返回父Loader的方式，于是就返回null。
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        loader.loadClass("com.el.jichu.jvm.LoderTest");
        //使用Class.forName()来加载类，默认会执行初始化块
        Class.forName("com.el.jichu.jvm.LoderTest");
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
        Class.forName("com.el.jichu.jvm.LoderTest", false, loader);

        /**
         * Class.forName()和ClassLoader.loadClass()区别
         *
         * Class.forName()：将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块；
         * ClassLoader.loadClass()：只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
         * Class.forName(name, initialize, loader)带参函数也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象 。
         */

    }
}
