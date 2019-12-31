package thread.thread01.thread0915;

/**
 * @Author: DuanTong
 * @Date: 2019/9/15 21:23
 */
public class Run2 {

    public static void main(String[] args) throws InterruptedException {
        MyThread03 t3 = new MyThread03();
        System.out.println("start 之前 ---->" + t3.isAlive());
        t3.start();
        Thread.sleep(1000);
        System.out.println("start 之后 ---->" + t3.isAlive());

    }

}

class MyThread03 extends Thread{

    @Override
    public void run() {
        System.out.println("this ---->" + this.isAlive());
    }
}
