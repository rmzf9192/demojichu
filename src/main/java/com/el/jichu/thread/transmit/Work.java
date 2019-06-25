package com.el.jichu.thread.transmit;

import java.util.List;

public class Work {
    public void process(Data data, List<Integer> numbers) {
        for (int n : numbers) {
            data.value += n;
        }
    }

    public void process1(Data data, Integer... numbers) {
        for (int n : numbers) {
            data.value += n;
        }
    }
}
