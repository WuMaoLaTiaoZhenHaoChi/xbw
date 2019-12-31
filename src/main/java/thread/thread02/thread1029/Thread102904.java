package thread.thread02.thread1029;

/**
 * @Author: DuanTong
 * @Date: 2019/10/29 22:19
 */
public class Thread102904 {
    public static void main(String[] args) {
        Service04 s = new Service04();

        Thread04A a = new Thread04A(s);
        a.start();

        Thread04B b = new Thread04B(s);
        b.start();

    }

}

class Thread04B extends Thread {
    private Service04 service04;

    public Thread04B(Service04 service04) {
        this.service04 = service04;
    }

    @Override
    public void run() {
        service04.printB();
    }
}

class Thread04A extends Thread {
    private Service04 service04;

    public Thread04A(Service04 service04) {
        this.service04 = service04;
    }

    @Override
    public void run() {
        service04.printA();
    }
}

class Service04{
    public void printA(){
        synchronized (new Object()) {
            System.out.println(" method-A  start ");
            boolean b = true;
            while (b){

            }
            System.out.println(" method-B  end ");
        }
    }

    public void printB(){
        synchronized (new Object()) {
            System.out.println(" method-B start ");
            System.out.println(" method-B start ");
        }
    }
}

