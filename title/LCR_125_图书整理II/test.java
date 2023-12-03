package title.LCR_125_图书整理II;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

/*
class CQueue {

    Deque<Integer> q = new LinkedList<>();
    public CQueue() {
    }

    public void appendTail(int value) {
        q.offer(value);
    }

    public int deleteHead() {
        return q.isEmpty() ? -1 : q.poll();
    }
}*/

//method 双栈模拟
class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) return stack2.pop();
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
            return stack2.pop();
        }
        return -1;
    }
}