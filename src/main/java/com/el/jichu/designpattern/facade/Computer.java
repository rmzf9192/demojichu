package com.el.jichu.designpattern.facade;

/**
 * @Auther: roman.zhang
 * @Date: 2018/12/27 20:49
 * @Version:V1.0
 * @Description:Computer 外观模式
 */
public class Computer {
    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Computer() {
        this.cpu = new CPU();
        this.disk = new Disk();
        this.memory = new Memory();
    }

    public void startup() {
        System.out.println("start the computer");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start the computer finished");
    }

    public void shutdown() {
        System.out.println("shutdown the computer");
        disk.shutdown();
        memory.shutdown();
        cpu.shutdown();
        System.out.println("shutdown the computer finished");
    }
}
