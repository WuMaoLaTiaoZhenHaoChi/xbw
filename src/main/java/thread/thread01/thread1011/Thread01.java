package thread.thread01.thread1011;

/**
 * @Author: DuanTong
 * @Date: 2019/10/11 9:21
 */
public class Thread01 {

    public static void main(String[] args) {
        Thread101101 t = new Thread101101();

        ThreadA ta = new ThreadA(t);

        Thread101101 t2 = new Thread101101();
        ThreadB tb = new ThreadB(t2);

        ta.start();
        tb.start();

    }

}

class Thread101101{
    int num = 0;
    public synchronized void addStr(String name){
        //int num = 0;
        try {
            if (name.equals("a")){
                num = 100;
                System.out.println("a set end!");
                Thread.sleep(2000);
            }else {
                num = 200;
                System.out.println("b set end!");
            }
            System.out.println(name + " num : " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread{

    private Thread101101 thread;

    public ThreadA(Thread101101 thread) {
        super();
        this.thread = thread;
    }

    @Override
    public void run() {
        thread.addStr("a");
    }
}

class ThreadB extends Thread{
    private Thread101101 thread;

    public ThreadB(Thread101101 thread) {
        super();
        this.thread = thread;
    }

    @Override
    public void run() {
        thread.addStr("b");
    }
}
