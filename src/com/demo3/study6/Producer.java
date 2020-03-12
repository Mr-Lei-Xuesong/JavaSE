package com.demo3.study6;

public class Producer implements Runnable {
    private Box b;

    public Producer(Box b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 30; i++) {
            b.put(i);
        }
    }
}
