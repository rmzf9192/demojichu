package com.el.jichu.thread.threadpool;

public class MyTask implements Runnable {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyTask(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("run taskId = " + this.id + "线程名" + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.id);
    }
}
