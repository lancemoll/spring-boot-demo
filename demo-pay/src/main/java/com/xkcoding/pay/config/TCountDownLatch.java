package com.xkcoding.pay.config;

import java.util.concurrent.CountDownLatch;

public class TCountDownLatch {

    public static void main(String[] args) {


      CountDownLatch latch = new CountDownLatch(5);
      new Thread(() -> {


        for(long i = latch.getCount();i > 0;i--){
          latch.countDown();
          System.out.println("countdown" + latch.getCount());
        }
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("countdown" + latch.getCount());

      }).start();
      try {
        System.out.println("await");
        latch.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Waiter Released");

//
//      Increment increment = new Increment(latch);
//      Decrement decrement = new Decrement(latch);
//
//      new Thread(increment).start();
//      new Thread(decrement).start();
//
//      try {
//          Thread.sleep(6000);
//      } catch (InterruptedException e) {
//          e.printStackTrace();
//      }
    }
}

class Decrement implements Runnable {

    CountDownLatch countDownLatch;

    public Decrement(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {

            for(long i = countDownLatch.getCount();i > 0;i--){
                Thread.sleep(1000);
                System.out.println("countdown");
                this.countDownLatch.countDown();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Increment implements Runnable {

    CountDownLatch countDownLatch;

    public Increment(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("await");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waiter Released");
    }
}
