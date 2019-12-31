package thread.thread02.thread1029;

/**
 * @Author: DuanTong
 * @Date: 2019/10/29 21:17
 */
public class Thread102901 {

    public static void main(String[] args) {
        Service01A service01A = new Service01A();
        Service01A service01A1 = new Service01A();
        Thread01A a = new Thread01A(service01A);
        a.setName("A");
        a.start();

        Thread01B b = new Thread01B(service01A1);
        b.setName("B");
        b.start();

    }

}

class Thread01B extends Thread{
    private Service01A service01A;

    public Thread01B(Service01A service01A) {
        this.service01A = service01A;
    }

    @Override
    public void run() {
        service01A.printB();
    }
}

class Thread01A extends Thread {
    private Service01A service01A;

    public Thread01A(Service01A service01A) {
        this.service01A = service01A;
    }

    @Override
    public void run() {
        service01A.printA();
    }
}

class Service01A {

    public void printA() {
        synchronized (Service01A.class) {
            try {
                System.out.println(Thread.currentThread().getName() + " 进入printA方法的时间为 " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " 退出printA方法的时间为 " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (Service01A.class) {
            System.out.println(Thread.currentThread().getName() + " 进入printB方法的时间为 " + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + " 退出printB方法的时间为 " + System.currentTimeMillis());
        }

    }

/*    synchronized public static void printA() {
        try {
            System.out.println(Thread.currentThread().getName() + " 进入printA方法的时间为 " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " 退出printA方法的时间为 " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        System.out.println(Thread.currentThread().getName() + " 进入printB方法的时间为 " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + " 退出printB方法的时间为 " + System.currentTimeMillis());

    }*/

}
