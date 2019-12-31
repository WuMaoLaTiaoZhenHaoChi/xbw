package leetcode.month11;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Author: 小霸王
 * @Date: 2019/11/22 15:57
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 *
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 */
public class Solution1122 {
    public static void main(String[] args) throws IOException {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.number((mark) -> System.out.println(mark));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class FizzBuzz {
    private int n;
    private int mark = 1;
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    Condition conditionD = lock.newCondition();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try {
            while (mark <= n ){
                while (mark % 3 != 0){
                    conditionA.await();
                }
                printFizz.run();
                mark ++;
                conditionD.signal();
            }
        }finally {
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (mark <= n){
                while (mark % 5 != 0){
                    conditionB.await();
                }
                printBuzz.run();
                mark ++;
                conditionD.signal();
            }
        }finally {
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (mark <= n){
                while (mark % 5 != 0 || mark % 3 != 0){
                    conditionC.await();
                }
                printFizzBuzz.run();
                mark ++;
                conditionD.signal();
            }
        }finally {
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (mark <= n){
                while (mark % 3 == 0 || mark % 5 == 0){
                    conditionD.await();
                }
                if (mark % 3 == 0 && mark % 5 ==0){
                    conditionC.signal();
                }else if (mark % 5 == 0){
                    conditionB.signal();
                }else if (mark % 3 == 0){
                    conditionA.signal();
                }else{
                    printNumber.accept(mark);
                    mark++;
                }
            }
        }finally {
            lock.unlock();
        }
    }
}
