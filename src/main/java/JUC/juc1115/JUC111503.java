package JUC.juc1115;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: 小霸王
 * @Date: 2019/11/15 11:10
 */
public class JUC111503 {
    public static void main(String[] args) throws Exception {
        RunnableDemo poolDemo = new RunnableDemo();
        CallableDemo callable = new CallableDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(poolDemo);
        Future<Integer> submit1 = executorService.submit(callable);
        System.out.println(submit1.get());
        //new Thread(poolDemo," ThreadDemo ").start();
    }

}


class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + (int)(Math.random() * 100));
    }
}

class CallableDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int num = (int)(Math.random() * 100);
        System.out.println(Thread.currentThread().getName() + num);
        return num;
    }
}