package thread.thread01.thread0918;

/**
 * @Author: DuanTong
 * @Date: 2019/9/18 21:23
 */
public class MyThread091802 {

    public static void main(String[] args) {
        try {
            Thread02 t2 = new Thread02();
            t2.start();
            Thread.sleep(1000);
            t2.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main 方法异常咯！");
            e.printStackTrace();
        }
    }

}

class Thread02 extends Thread{

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run 方法开始执行！");
            System.out.println("run方法中此线程状态：" + this.isInterrupted());
            Thread.sleep(5000);
            System.out.println("run 方法执行完毕！");
        } catch (InterruptedException e) {
            System.out.println("run方法出异常了！！！ 此时线程状态：" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
