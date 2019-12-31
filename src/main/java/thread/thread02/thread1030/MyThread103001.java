package thread.thread02.thread1030;

/**
 * @Author: DuanTong
 * @Date: 2019/10/30 21:59
 */
public class MyThread103001 {
    public static void main(String[] args) {
        try {
            DealThread run = new DealThread();

            Thread thread1 = new Thread(run);
            run.setFlag("a");
            thread1.start();

            Thread thread2 = new Thread(run);
            run.setFlag("b");
            thread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class DealThread implements Runnable{

    private String name;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void setFlag(String name){
        this.name = name;
    }

    @Override
    public void run() {
        if (name.equals("a")){
            try {
                synchronized (lock1){
                    System.out.println(" name = " + name);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){
                System.out.println(" lock1 ---->  lock2");
            }
        }

        if (name.equals("b")){
            synchronized (lock2){
                System.out.println(" name = " + name);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println(" lock2 ---->  lock1 ");
                }
            }
        }


    }
}
