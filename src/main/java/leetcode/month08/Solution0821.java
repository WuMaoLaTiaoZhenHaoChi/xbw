package leetcode.month08;

import java.util.Stack;

/**
 * @Author: DuanTong
 * @Date: 2019/8/21 19:39
 */
public class Solution0821 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}


class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> helper;

    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if (helper.empty() || stack.peek() < helper.peek())
            helper.add(x);
        else
            helper.add(helper.peek());
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        if (stack.empty())
            throw new RuntimeException("stack is null");
        else
            return stack.peek();
    }

    public int getMin() {
       if (!helper.empty())
           return helper.peek();
       else
           throw new RuntimeException("Stack is null!");
    }
}

/*class MinStack {

    List<Integer> stack = new ArrayList<>();
    int min;

    public MinStack() {

    }

    public void push(int x) {
        stack.add(x);
    }

    public void pop() {
        if (stack.size() > 0)
            stack.remove(stack.size() - 1);
        else
            System.out.println("Stack is null!");
    }

    public int top() {
        if (stack.size() > 0)
            return stack.get(stack.size() - 1);
        else
            System.out.println("Stack is null!");
        return 0;
    }

    public int getMin() {
        if (stack.size() > 0) {
            min = stack.get(0);
            for (int i:stack) {
                min = min <= i ? min : i;
            }
            return min;
        } else
            System.out.println("Stack is null");
        return 0;
    }
}*/
