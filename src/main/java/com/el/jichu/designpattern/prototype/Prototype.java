package com.el.jichu.designpattern.prototype;

import java.io.*;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/24 22:05
 * @Version:V1.0
 * @Description:Prototype 原型模式
 */
public class Prototype implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String string;
    private Serializable obj;

    /*
    浅复制
     */
    public Object clone() throws CloneNotSupportedException {
        Prototype clone = (Prototype) super.clone();
        return clone;
    }

    /*
    深复制
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        //写入当前对象的二进制
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(outputStream);

        //读出二进制流产生的对象
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        ObjectInputStream inputStream1 = new ObjectInputStream(inputStream);
        return inputStream1.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Serializable getObj() {
        return obj;
    }

    public void setObj(Serializable obj) {
        this.obj = obj;
    }
}

class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;
}
