package thread.thread01.thread1017;

/**
 * @Author: DuanTong
 * @Date: 2019/10/17 14:46
 */
public class MyThread {
    public static void main(String[] args) {
        Test thread = new Test();

        Thread01 thread01 = new Thread01(thread);
        thread01.setName("t1");
        thread01.start();
        Thread02 thread02 = new Thread02(thread);
        thread02.setName("t2");
        thread02.start();
    }
}

class Thread01 extends Thread{

    private Test test;

    public Thread01(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        super.run();
        test.print("BBBB","CCCC");
    }
}

class Thread02 extends Thread{
    private Test test;

    public Thread02(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        super.run();
        test.getStr();
    }

}

class Test{

    private String name;
    private String password;

    String str = "AAA";
    public void print(String name,String password){

        synchronized(str) {
            try {
                System.out.println(" print start time " + System.currentTimeMillis() );
                this.name = name;
                Thread.sleep(2000);
                this.password = password;
                System.out.println(Thread.currentThread().getName() + name + password);
                System.out.println(" print end time " + System.currentTimeMillis() );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void getStr(){
        System.out.println(" getStr start time " + System.currentTimeMillis() );
        System.out.println(Thread.currentThread().getName() + str);
        System.out.println(" getStr end time " + System.currentTimeMillis() );
    }

}
