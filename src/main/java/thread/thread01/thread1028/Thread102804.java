package thread.thread01.thread1028;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 22:26
 */
public class Thread102804 {
    public static void main(String[] args) {
        MyObject04 myObject04 = new MyObject04();
        MyService04 myService04 = new MyService04();

        MyThread04 myThread04 = new MyThread04(myObject04, myService04);
        myThread04.setName(" Thread-A");
        myThread04.start();

        MyThread05 myThread05 = new MyThread05(myObject04, myService04);
        myThread05.setName(" Thread-B");
        myThread05.start();

    }
}

class MyThread05 extends Thread{

    private MyObject04 myObject04;
    private MyService04 myService04;

    public MyThread05(MyObject04 myObject04, MyService04 myService04) {
        this.myObject04 = myObject04;
        this.myService04 = myService04;
    }

    @Override
    public void run() {
        myObject04.print();
    }
}

class MyThread04 extends Thread{
    private MyObject04 myObject04;
    private MyService04 myService04;

    public MyThread04(MyObject04 myObject04, MyService04 myService04) {
        this.myObject04 = myObject04;
        this.myService04 = myService04;
    }

    @Override
    public void run() {
        myService04.myMethod(myObject04);
    }
}

class MyService04{
    public void myMethod(MyObject04 object04){
        synchronized (object04) {
            try {
                System.out.println(Thread.currentThread().getName() + " MyService04 获得锁的时间 " + System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " MyService04 失去锁的时间 " + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

class MyObject04{
    public void print(){
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " MyObject04 获得锁的时间 " + System.currentTimeMillis());
            System.out.println(" =============== ");
            System.out.println(Thread.currentThread().getName() + " MyObject04 失去锁的时间 " + System.currentTimeMillis());
        }
    }

}