package thread.thread01.thread0915;

/**
 * @Author: DuanTong
 * @Date: 2019/9/15 10:31
 */
public class Run1 {

    public static void main(String[] args){
        MyThread1 r = new MyThread1();
        r.setName("线程对象");
        Thread t = new Thread(r);
        t.setName("当前运行的线程");
        t.start();
        //t.run();

    }

}

class MyThread1 extends Thread{

    public MyThread1() {
        System.out.println("MyThread begin!");
        System.out.println("构造方法（Thread.currentThread）：" + Thread.currentThread().getName());
        System.out.println("构造方法（this）：" + this.getName());
        System.out.println("MyThread end!");
    }

    @Override
    public void run() {
        System.out.println("run begin!");
        System.out.println("run方法（Thread.currentThread）：" + Thread.currentThread().getName());
        System.out.println("run方法（this）：" + this.getName());
        System.out.println("run end!");
    }
}
