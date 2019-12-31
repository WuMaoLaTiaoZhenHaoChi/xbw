package thread.thread01.thread0919;

/**
 * @Author: DuanTong
 * @Date: 2019/9/19 22:21
 */
public class Thread091902 {

    public static void main(String[] args) {
        try {
            MyThread03 t3 = new MyThread03();
            System.out.println("初始  i= " + t3.getI());
            t3.start();
            Thread.sleep(5000);

            t3.suspend();
            System.out.println("暂停  i= " + t3.getI());
            Thread.sleep(5000);
            System.out.println("sleep 5s 之后  i= " + t3.getI());
            System.out.println("准备重新开始 i= " + t3.getI());
            t3.resume();
            Thread.sleep(5000);
            System.out.println("重新开始 5s 之后  i= " + t3.getI());
            t3.suspend();
            System.out.println("准备暂停  i= " + t3.getI());
            Thread.sleep(5000);
            System.out.println("暂停 5s 之后 i= " + t3.getI());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class MyThread03 extends Thread{

    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                i++;
                System.out.println("run... i = " + i );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}