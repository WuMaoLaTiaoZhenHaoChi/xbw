package thread.thread01.thread0918;

/**
 * @Author: DuanTong
 * @Date: 2019/9/18 21:23
 */
public class MyThread091801 {

    public static void main(String[] args) {
        try {
            Thread01 run1 = new Thread01();
            run1.start();
            Thread.sleep(1000);
            run1.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main 的catch中！！！");
            e.printStackTrace();
        }
        System.out.println("end!!!");

    }

}

class Thread01 extends Thread{

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0;i < 500000;i++){
                if (this.interrupted()){
                    System.out.println("我已经被停止了！！");
                    throw new InterruptedException();
                }
                System.out.println("i = " + i);
            }
            System.out.println("for循环结束！");
        } catch (Exception e) {
            System.out.println("进入run方法中的catch中了！！！");
            e.printStackTrace();
        }
    }
}
