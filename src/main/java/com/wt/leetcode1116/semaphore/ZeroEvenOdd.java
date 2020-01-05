package com.wt.leetcode1116.semaphore;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    Semaphore zeroS = new Semaphore(1);
    Semaphore evenS = new Semaphore(0);
    Semaphore oddS = new Semaphore(0);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroS.acquire();
            printNumber.accept(0);
            if ((i&1)==0) {
                oddS.release();
            } else {
                evenS.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenS.acquire();
            printNumber.accept(i);
            zeroS.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            oddS.acquire();
            printNumber.accept(i);
            zeroS.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeo = new ZeroEvenOdd(2);
        Thread t1 = new Thread(() -> {
            try {
                zeo.zero((t) -> System.out.println(String.valueOf(t)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeo.even((t) -> System.out.println(String.valueOf(t)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeo.odd((t) -> System.out.println(String.valueOf(t)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        t3.run();
        t1.run();
//        t2.run();
    }
}
