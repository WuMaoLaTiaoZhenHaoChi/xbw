package duant.thread;

/**
 * @Author: duant
 * @Date: 2020/1/9 22:25
 */
public class ThreadPoolExecutorTest3 {

    public static void main(String[] args) {

        MyThread3 thread1 = new MyThread3("lockA","lockB");
//        MyThread3 thread2 = new MyThread3("lockB","lockA");


        new Thread(thread1).start();

//        new Thread(thread2).start();

    }

}

class MyThread3 implements Runnable{

    private String lockA;
    private String lockB;

    public MyThread3(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized(lockA){
            System.out.println(Thread.currentThread().getName() + " 持有线程 " + lockA + " ，继续获取线程 " + lockB);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized ((lockB)){
                System.out.println(Thread.currentThread().getName() + " 持有线程 " + lockB + " ，继续获取线程 " + lockA);

            }
        }

    }
}
