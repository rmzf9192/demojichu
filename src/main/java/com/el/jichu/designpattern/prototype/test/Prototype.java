package com.el.jichu.designpattern.prototype.test;

import java.io.*;

/**
 * @author Roman.zhang
 * @Date: 2019/7/4 15:42
 * @Version:V1.0
 * @Description:Prototype
 */
public class Prototype implements Cloneable , Serializable {

    private static final long serialVersionUID = 1L;

    private String string;

    private SerializableObject obj;

    /**
     * 浅复制
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Prototype clone = (Prototype) super.clone();
        return clone;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }
}
class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;
}
