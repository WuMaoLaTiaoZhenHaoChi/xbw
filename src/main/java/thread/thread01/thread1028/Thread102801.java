package thread.thread01.thread1028;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 21:07
 */
public class Thread102801 {

    public static void main(String[] args) throws InterruptedException {
        MyOneList myOneList = new MyOneList();

        MyThread1 myThread1 = new MyThread1(myOneList);
        myThread1.setName("myThread01");
        myThread1.start();

        MyThread2 myThread2 = new MyThread2(myOneList);
        myThread2.setName("myThread2");
        myThread2.start();
        Thread.sleep(6000);
        System.out.println(myOneList.getListSize());
    }

}

class MyThread2 extends Thread{

    private MyOneList myOneList;

    public MyThread2(MyOneList myOneList) {
        this.myOneList = myOneList;
    }

    @Override
    public void run() {
        Myservice myservice = new Myservice();
        myservice.addServiceMethod(myOneList,"B");
    }
}

class MyThread1 extends Thread{

    private MyOneList myOneList;

    public MyThread1(MyOneList myOneList) {
        this.myOneList = myOneList;
    }

    @Override
    public void run() {
        Myservice myservice = new Myservice();
        myservice.addServiceMethod(myOneList,"A");

    }
}

class Myservice{
    
     public MyOneList addServiceMethod(MyOneList myOneList, String data){
        try {
            synchronized (myOneList
            ) {
                if (myOneList.getListSize() < 1){
                    Thread.sleep(2000);
                    myOneList.add(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myOneList;
    }
}

class MyOneList {

    private List<String> list = new ArrayList();

    public void add(String data) {
        list.add(data);
    }

    public int getListSize() {
        return list.size();
    }
}