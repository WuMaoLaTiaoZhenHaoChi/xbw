package thread.thread02.thread1030;

/**
 * @Author: DuanTong
 * @Date: 2019/10/30 22:34
 */
public class MyThread103003 {
    public static void main(String[] args) {
        OutClass.Inner inner = new OutClass.Inner();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method2();
            }
        });
        t1.start();
        t2.start();
    }

}

class OutClass{

    static class Inner{
        public void method1(){
            synchronized (""){
                for (int i = 0; i < 20; i++) {
                    System.out.println(" method1 " + i);
                }

            }
        }
        synchronized public void method2(){
            for (int i = 21; i < 40; i++) {
                System.out.println(" method2 " + i);
            }
        }
    }


}
