package thread.thread01.thread1024;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/10/24 15:11
 */
public class Thread1024 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        ThreadA threadA = new ThreadA(t);
        threadA.setName("ThreadA");
        threadA.start();

        ThreadB threadB = new ThreadB(t);
        threadB.setName("ThreadB");
        threadB.start();

    }
}

class ThreadB extends Thread{
    private MyThread myThread;

    public ThreadB(MyThread myThread) {
        System.out.println(" addList start " + System.currentTimeMillis());
        this.myThread = myThread;
        System.out.println(" addList end " + System.currentTimeMillis());
    }

    @Override
    public void run() {
        System.out.println(" getList start " + System.currentTimeMillis());
        myThread.getList();
        System.out.println(" getList end " + System.currentTimeMillis());
    }
}

class ThreadA extends Thread{
    private MyThread myThread;

    public ThreadA(MyThread myThread) {
        this.myThread = myThread;
    }

    @Override
    public void run() {
        for (int i =0;i < 10;i++){
            myThread.addList(i);
        }
    }
}

class MyThread{
    List<Integer> list = new ArrayList<>();

    synchronized public void addList(int n){
        try {
            Thread.sleep(1000);
            list.add(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    synchronized public void getList(){
        System.out.println(list);
    }

}
