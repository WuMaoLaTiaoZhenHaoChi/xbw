package JUC.juc1114;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: 小霸王
 * @Date: 2019/11/14 14:30
 *
 * Callable接口
 */
public class JUC111404 {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<Long> reslut = new FutureTask<>(myCallable);
        new Thread(reslut).start();
        try {
            Long aLong = reslut.get();
            System.out.println(aLong);
        } catch (Exception e) {
        }

    }

}

class MyCallable implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        System.out.println("Thread.currentThread().getName()" + Thread.currentThread().getName());
        System.out.println("this" + this);
        return System.currentTimeMillis();
    }
}