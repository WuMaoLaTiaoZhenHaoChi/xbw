package thread.thread01.thread0919;

/**
 * @Author: DuanTong
 * @Date: 2019/9/19 21:26
 */
public class Thread091901 {

    public static void main(String[] args) {
        try {
            SynchronizedObject synchronizedObject = new SynchronizedObject();
            Mythread01 mythread01 = new Mythread01(synchronizedObject);
            mythread01.start();
            Thread.sleep(500);
            mythread01.stop();
            System.out.println(synchronizedObject.getUsername() + synchronizedObject.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class Mythread01 extends Thread {

    private SynchronizedObject synchronizedObject;

    public Mythread01(SynchronizedObject synchronizedObject) {
        this.synchronizedObject = synchronizedObject;
    }

    @Override
    public void run() {
        synchronizedObject.printString("b", "bb");
    }
}

class SynchronizedObject {

    private String username = "a";
    private String password = "aa";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized public void printString(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}