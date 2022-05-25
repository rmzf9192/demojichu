package com.el.jichu.designpattern.memento.test;

/**
 * @author Roman.zhang
 * @Date: 2019/7/9 14:26
 * @Version:V1.0
 * @Description:GameRole
 */
public class GameRole {
    private int vit;
    private int def;

    public Memento createMemento(){
        return new Memento(vit,def);
    }

    public void recoverGameRole(Memento memento){
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }

    public void display(){
        System.out.println("游戏角色当前攻击力："+this.vit+" 当前防御力："+this.def);

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
