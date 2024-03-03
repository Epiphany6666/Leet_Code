package title.用队列实现栈255;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
}

// method：自写
class MyStack0 {
    Deque<Integer> q1 = new ArrayDeque<>();
    Deque<Integer> q2 = new ArrayDeque<>();
    public void push(int x) {
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        q1.offer(x);
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * 参考题解：力扣官方题解
 */
//method 1：两个队列
class MyStack1 {
    Deque<Integer> q1;
    Deque<Integer> q2;
    public MyStack1() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Deque<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

//method 2：一个队列
class MyStack {
    Deque<Integer> q;
    public MyStack() {
        q = new ArrayDeque<>();
    }

    public void push(int x) {
        int n = q.size();
        q.offer(x);
        for (int i = 0; i < n; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}