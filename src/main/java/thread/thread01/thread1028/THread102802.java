package thread.thread01.thread1028;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 21:36
 */
public class THread102802 {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        MyService myService = new MyService();
        Thread1 thread1 = new Thread1(myObject,myService);
        thread1.setName("thread-A");
        thread1.start();

        MyObject myObject2 = new MyObject();
        Thread2 thread2 = new Thread2(myObject2, myService);
        thread2.setName("thread-B");
        thread2.start();

    }

}

class Thread2 extends Thread{
    private MyObject myObject;
    private MyService myService;

    public Thread2(MyObject myObject, MyService myService) {
        this.myObject = myObject;
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.myMethod(myObject);
    }
}

class Thread1 extends Thread{
    private MyObject myObject;
    private MyService myService;

    public Thread1(MyObject myObject, MyService myService) {
        this.myObject = myObject;
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.myMethod(myObject);
    }
}

class MyService{

    public void myMethod(MyObject myObject){
        try {
            synchronized (myObject){
                System.out.println(Thread.currentThread().getName() + " 获取锁的时间为 " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " 失去锁的时间为 " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyObject{
    //空类
}
