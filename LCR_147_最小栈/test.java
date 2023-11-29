package title.LCR_147_最小栈;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

/*
class MinStack {

    Deque<Integer> stack;
    Deque<Integer> min_stack;
    */
/** initialize your data structure here. *//*

    public MinStack() {
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        while (!min_stack.isEmpty() && min_stack.peekLast() > x) min_stack.pop();
        min_stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (min_stack.peekLast() == x)  min_stack.pop();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return min_stack.peekLast();
    }
}*/

/*
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min_stack;
    public MinStack() {
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
        min_stack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        //note push是从左往右进栈的，所以栈顶是在左边！
//        min_stack.push(Math.min(min_stack.peekLast(), val));
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return min_stack.peekLast();
    }
}*/


class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min_stack;
    public MinStack() {
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
        min_stack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        min_stack.push(Math.min(min_stack.peek(), val));
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
