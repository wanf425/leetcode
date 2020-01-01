package com.wt.leetcode1115.semaphore;

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooS = new Semaphore(1);
    private Semaphore barS = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooS.acquire();
            printFoo.run();
            barS.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barS.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooS.release();
        }
    }
}
