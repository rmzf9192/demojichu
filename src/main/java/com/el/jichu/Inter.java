package com.el.jichu;

/**
 * <p>
 * 功能说明
 * </p >
 *
 * @author Roman.Zhang
 * @date 2020/10/19
 */
public class Inter implements Interface1 {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public void jiao() {
        return;
    }

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }
}
