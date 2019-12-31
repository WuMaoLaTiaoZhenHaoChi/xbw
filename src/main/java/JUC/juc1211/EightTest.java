package JUC.juc1211;

/**
 * @Author: duant
 * @Date: 2019/12/11 14:02
 */
public class EightTest {

    public static void main(String[] args) {
        MyTest test1 = new MyTest();
        MyTest test2 = new MyTest();

        new Thread(() -> {
           test1.methodA();
        }).start();

        new Thread(() ->{
            test2.methodA();
        }).start();

    }

}


class MyTest{

    public static synchronized void methodA(){
        System.out.println("-----methodA start-----");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----methodA end-----");
    }

    public void methodB(){
        System.out.println("-----methodB-----");
    }

}