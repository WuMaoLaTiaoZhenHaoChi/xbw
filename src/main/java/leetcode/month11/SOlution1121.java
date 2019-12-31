package leetcode.month11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 小霸王
 * @Date: 2019/11/21 14:35
 *
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 */
public class SOlution1121 {

    /**
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     *
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     *
     * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习
     */
    public static void main(String[] args) {
        SOlution1121 s = new SOlution1121();
        System.out.println(s.canFinish(2,new int[][]{
                {0,1}
        }));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        int[] pre_num = new int[numCourses];
        for (int[] nums : prerequisites)
            pre_num[nums[0]] ++;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pre_num[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()){
            int num = queue.poll();
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == num){
                    pre_num[prerequisites[i][0]] --;
                    if (pre_num[prerequisites[i][0]] == 0){
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
            numCourses --;
        }
        return numCourses == 0;
    }

}


class Foo {

    private int mark = 1;
    Lock lock = new ReentrantLock();
    Condition conditionOne = lock.newCondition();
    Condition conditionTwo = lock.newCondition();
    Condition conditionThree = lock.newCondition();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            if (mark != 1){
                conditionOne.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            mark = 2;
            conditionTwo.signal();
        }finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            if (mark != 2){
                conditionTwo.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            mark = 3;
            conditionThree.signal();
        }finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            if (mark != 3){
                conditionThree.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            mark = 1;
            conditionOne.signal();
        }finally {
            lock.unlock();
        }
    }
}
