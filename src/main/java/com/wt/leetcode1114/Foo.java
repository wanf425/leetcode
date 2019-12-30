package com.wt.leetcode1114;

import java.util.concurrent.CountDownLatch;

public class Foo {

    public Foo() {
        cdl = new CountDownLatch(3);
    }

    private CountDownLatch cdl;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while(true) {
            if(cdl.getCount() == 3) {
                printFirst.run();
                cdl.countDown();
                break;
            }
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(true) {
            if(cdl.getCount() == 2) {
                printSecond.run();
                cdl.countDown();
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(true) {
            if(cdl.getCount() == 1) {
                printThird.run();
                cdl.countDown();
                break;
            }
        }
    }
}
