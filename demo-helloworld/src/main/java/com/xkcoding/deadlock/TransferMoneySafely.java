package com.xkcoding.deadlock;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransferMoneySafely {

    private final Object lock = new Object();

    public void transferMoney(Account fromAccount, Account toAccount, BigDecimal amount) throws InterruptedException {

        if(fromAccount.getUserId() > toAccount.getUserId()) {
            synchronized (fromAccount) {
                Thread.sleep(2000);
                synchronized (toAccount) {
                    doTransfer(fromAccount,toAccount, amount);
                }
            }
        } else if(fromAccount.getUserId() < toAccount.getUserId()) {
            synchronized (toAccount) {
                Thread.sleep(2000);
                synchronized (fromAccount) {
                    doTransfer(fromAccount,toAccount, amount);
                }
            }
        } else {
            synchronized (lock) {
                synchronized (fromAccount){
                    Thread.sleep(2000);
                    synchronized (toAccount) {
                        doTransfer(fromAccount,toAccount, amount);
                    }
                }
            }
        }
    }

    public void doTransfer(Account fromAccount, Account toAccount, BigDecimal amount) {
        if(fromAccount.getAmount().compareTo(amount) < 0) {
            throw new RuntimeException("转账金额错误");
        } else {
            fromAccount.debit(amount);
            toAccount.credit(amount);
            System.out.println("fromAccount amount is " + fromAccount.getAmount() + ", toAccount amount is " + toAccount.getAmount());
        }
    }

    public static void main(String[] agrs) {
        TransferMoneySafely transferMoneySafely = new TransferMoneySafely();
        Account fromAccount = new Account(1231231233, new BigDecimal("10000"));
        Account toAccount = new Account(1231231231, new BigDecimal("10000"));
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            transferMoneySafely.transferMoney(fromAccount, toAccount, new BigDecimal("2000"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        executorService.submit(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            transferMoneySafely.transferMoney(toAccount ,fromAccount, new BigDecimal("2000"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }


//    public boolean transferMoney(Account fromAccount, Account toAccount, BigDecimal amount, long timeout, TimeUnit unit)
//        throws InsufficientResourcesException, InterruptedException {
//        //回避时间 = 固定时间+随机时间
//        long fixDelay = 2;
//        Random random = new Random();
//        random.setSeed(fixDelay);
//        long randMod = random.nextLong();
//        long stopTime = System.nanoTime() + unit.toNanos(timeout);
//
//        while(true) {
//            if(fromAccount.lock.tryLock()) {
//                try {
//                    if(toAccount.lock.tryLock()) {
//                        try {
//                            if(fromAccount.getAmount().compareTo(amount) < 0) {
//                                throw new InsufficientResourcesException();
//                            } else {
//                                fromAccount.debit(amount);
//                                toAccount.credit(amount);
//                                System.out.println("fromAccount amount is " + fromAccount.getAmount() + ", toAccount amount is " + toAccount.getAmount());
//                                return true;
//                            }
//                        } finally {
//                            //释放锁必须放在finally块中，否则，异常时无法释放锁
//                            toAccount.lock.unlock();
//                        }
//                    }
//                }finally {
//
//                    fromAccount.lock.unlock();
//                }
//            }
//            //超时退出
//            if(System.nanoTime() > stopTime) {
//                System.out.println("Time out!");
//                return false;
//            }
//            //回退
//            NANOSECONDS.sleep(fixDelay + random.nextLong() % randMod);
//        }
//    }

}
