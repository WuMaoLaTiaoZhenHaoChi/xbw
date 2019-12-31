package thread.thread02.thread1029;

/**
 * @Author: DuanTong
 * @Date: 2019/10/29 21:17
 */
public class Thread102902 {

    public static void main(String[] args) {
        Service02A s = new Service02A();

        Thread02A a = new Thread02A(s);
        a.setName(" A ");
        a.start();

        Thread02B b = new Thread02B(s);
        b.setName(" B ");
        b.start();

        Thread02C c = new Thread02C(s);
        c.setName(" C ");
        c.start();

    }

}

class Thread02C extends Thread{
    private Service02A s;

    public Thread02C(Service02A s) {
        this.s = s;
    }

    @Override
    public void run() {
        s.printC();
    }
}

class Thread02B extends Thread {
    private Service02A s;

    public Thread02B(Service02A s) {
        this.s = s;
    }

    @Override
    public void run() {
        s.printB();
    }
}

class Thread02A extends Thread {
    private Service02A s;

    public Thread02A(Service02A s) {
        this.s = s;
    }

    @Override
    public void run() {
        s.printA();
    }
}

class Service02A{
    synchronized public static void printA() {
        try {
            System.out.println(Thread.currentThread().getName() + "  进入printA方法的时间为 " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "  退出printA方法的时间为 " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        System.out.println(Thread.currentThread().getName() + "  进入printB方法的时间为 " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + "  退出printB方法的时间为 " + System.currentTimeMillis());

    }

    synchronized public void printC() {
        System.out.println(Thread.currentThread().getName() + "  进入 printC 方法的时间为 " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + "  退出 printC 方法的时间为 " + System.currentTimeMillis());
    }

}


