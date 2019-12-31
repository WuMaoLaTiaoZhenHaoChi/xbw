package thread.thread01.thread0910;

/**
 * @Author: DuanTong
 * @Date: 2019/9/10 22:10
 */

public class ThreadLoginServlet{

    public static void main(String[] args) {
        Runnable rA = new LoginA();
        Runnable rB = new LoginB();

        Thread tA = new Thread(rA);
        Thread tB = new Thread(rB);

        tA.start();
        tB.start();

    }

}

//模拟一个servlet组件
class LoginServlet {

    private static String userNameRef;
    private static String passwordRef;

    synchronized public static void doPost(String username,String password){
        userNameRef = username;
        try {
            if ("a".equals(username)){
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username:" + userNameRef + ",password:" + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

//模拟两个登陆线程
class LoginA implements Runnable{

    @Override
    public void run() {
        LoginServlet.doPost("a","aa");
    }
}

class LoginB implements Runnable{

    @Override
    public void run() {
        LoginServlet.doPost("b","bb");
    }
}