package thread.thread01.thread0918;

/**
 * @Author: DuanTong
 * @Date: 2019/9/18 22:06
 */
public class MyThread091803 {

    public static void main(String[] args) {
        try {
            System.out.println("main 方法开始！");
            Thread03 t3 = new Thread03();
            t3.start();
            Thread.sleep(500);
            t3.stop();
            //t3.interrupt();
            System.out.println("main 方法结束！");
        } catch (InterruptedException e) {
            System.out.println("main 方法抛出异常");
            e.printStackTrace();
        }
    }

}

class Thread03 extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("run 方法开始！");
            for (int i = 0;i < 50000;i++)
                System.out.println("i -----> " + i);
            System.out.println("for 循环结束 线程休眠！");
            Thread.sleep(2000);
            System.out.println("run 方法结束！");
        } catch (Exception e) {
            System.out.println("run 方法抛出异常！");
            e.printStackTrace();
        }
    }
}