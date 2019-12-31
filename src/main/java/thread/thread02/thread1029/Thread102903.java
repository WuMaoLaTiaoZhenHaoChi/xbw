package thread.thread02.thread1029;

/**
 * @Author: DuanTong
 * @Date: 2019/10/29 21:48
 */
public class Thread102903 {
    public static void main(String[] args) {
        Service03A s = new Service03A();

        Thread03A a = new Thread03A(s);
        a.setName(" A ");
        a.start();

        Thread03B b = new Thread03B(s);
        b.setName(" B ");
        b.start();

    }
    
}

class Thread03B extends Thread {
    private Service03A s;

    public Thread03B(Service03A s) {
        this.s = s;
    }

    @Override
    public void run() {
        s.printStr("AA");
    }
}

class Thread03A extends Thread {
    private Service03A s;

    public Thread03A(Service03A s) {
        this.s = s;
    }

    @Override
    public void run() {
        s.printStr("AA");
    }
}

class Service03A{
    
    public void printStr(String str){
        synchronized (str){
            while (true){
                System.out.println(Thread.currentThread().getName() + " : " + str);
            }
        }
    }
    
}
