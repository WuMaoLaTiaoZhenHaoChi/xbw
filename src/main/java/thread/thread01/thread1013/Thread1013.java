package thread.thread01.thread1013;

/**
 * @Author: DuanTong
 * @Date: 2019/10/13 11:08
 */
public class Thread1013 {

    public static void main(String[] args) {
        PublicVal publicVal = new PublicVal();

        MyThread t = new MyThread(publicVal);
        t.start();
        publicVal.getVal();

    }

}

class MyThread extends Thread{

    PublicVal publicVal;

    public MyThread(PublicVal publicVal) {
        this.publicVal = publicVal;
    }

    @Override
    public void run() {
        publicVal.setVal("AAAAA","BBBBB");
    }
}

class PublicVal{

    String username = "username";
    String password = "password";

    public void setVal(String username,String password){
        try {
            this.username = username;
            Thread.sleep(2000);
            this.password = password;
            System.out.println(Thread.currentThread().getName() + "setVal ----> username = " + username +
                    "password = " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getVal(){
        System.out.println(Thread.currentThread().getName() + "getVal ----> username = " + username +
                "password = " + password);
    }
}
