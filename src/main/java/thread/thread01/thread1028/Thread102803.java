package thread.thread01.thread1028;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 22:10
 */
public class Thread102803 {
    public static void main(String[] args) {
        MyObject2 myObject2 = new MyObject2();
        MyService02 myService02 = new MyService02();

        Thread04 thread04 = new Thread04(myObject2, myService02);
        thread04.setName(" thread-B ");
        thread04.start();

        Thread03 thread03 = new Thread03(myObject2, myService02);
        thread03.setName(" thread-A ");
        thread03.start();
    }
}

class Thread04 extends Thread{
    private MyObject2 myObject2;
    private MyService02 myService02;

    public Thread04(MyObject2 myObject2, MyService02 myService02) {
        this.myObject2 = myObject2;
        this.myService02 = myService02;
    }

    @Override
    public void run() {
        myObject2.print();
    }
}

class Thread03 extends Thread{
    private MyObject2 myObject2;
    private MyService02 myService02;

    public Thread03(MyObject2 myObject2, MyService02 myService02) {
        this.myObject2 = myObject2;
        this.myService02 = myService02;
    }

    @Override
    public void run() {
        myService02.myMethod02(myObject2);
    }
}

class MyService02 {
    public void myMethod02(MyObject2 myObject2) {
        try {
            synchronized (myObject2) {
                System.out.println(Thread.currentThread().getName() + " 取得锁的时间 " + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " 取得锁的时间 " + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class MyObject2 {
    synchronized public void print() {
        System.out.println(Thread.currentThread().getName() + " 取得锁的时间 " + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("======================");
        System.out.println(Thread.currentThread().getName() + " 取得锁的时间 " + System.currentTimeMillis());
    }
}