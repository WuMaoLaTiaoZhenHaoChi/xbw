package JUC.juc1114;

/**
 * @Author: 小霸王
 * @Date: 2019/11/14 9:17
 * 生产者消费者问题 Object.wait()
 */
public class JUC111401 {

    /*public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer1 = new Producer(clerk);
        Consumer consumer1 = new Consumer(clerk);

        new Thread(producer1, "生产者A").start();
        new Thread(consumer1, "消费者Z").start();
        new Thread(producer1, "生产者B").start();
        new Thread(consumer1, "消费者X").start();
    }*/

}

//店员
/*
class Clerk {
    private int produce = 0;

    //进货
    public synchronized void get() {
        while (produce >= 1) {
            System.out.println(" 仓库已满！ ");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + ++produce);
        this.notifyAll();

    }

    //出货
    public synchronized void sell() {
        while (produce <= 0) {
            System.out.println(" 已售空！ ");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + --produce);
        this.notifyAll();
    }

}

//生产者
class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            clerk.get();
        }
    }
}

//消费者
class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            clerk.sell();
        }
    }
}*/
