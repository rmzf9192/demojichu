package com.el.jichu.designpattern.memento.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 14:24
 * @Version:V1.0
 * @Description:Memento
 */
public class Memento {
    private int vit;
    private int def;

    public Memento(int vit, int def) {
        this.vit = vit;
        this.def = def;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
