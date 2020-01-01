package com.wt.leetcode1114.semaphore;

import java.util.concurrent.Semaphore;

public class Foo {
    public Foo() {

    }

    Semaphore firstS = new Semaphore(1);
    Semaphore secondS = new Semaphore(0);
    Semaphore thirdS = new Semaphore(0);


    public void first(Runnable printFirst) throws InterruptedException {
        firstS.acquire();
        printFirst.run();
        firstS.release();
        secondS.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondS.acquire();
        printSecond.run();
        thirdS.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdS.acquire();
        printThird.run();
    }
}
