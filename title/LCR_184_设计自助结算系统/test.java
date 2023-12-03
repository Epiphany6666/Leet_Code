package title.LCR_184_设计自助结算系统;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class test {
}

/*
class Checkout {
    PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> (j - i));
    Deque<Integer> q = new LinkedList<>();

    public int get_max() {
        if (!pq.isEmpty()) return pq.peek();
        else return -1;
    }

    public void add(int value) {
        pq.offer(value);
        q.offer(value);
    }

    //从此队列中删除指定元素的单个实例（如果存在）。更正式地说，如果此队列包含一个或多个此类元素，则删除元素 e，使 o.equals（e）。
    public int remove() {
        if (q.isEmpty()) return -1;
        int x =  q.poll();
        pq.remove(x);
        return x;
    }
}*/

class Checkout {
    Deque<Integer> q;
    Deque<Integer> d;
    public Checkout() {
        q = new LinkedList<>();
        d = new LinkedList<>();
    }

    public int get_max() {
        return d.isEmpty() ? -1 : d.peek();
    }

    public void add(int value) {
        q.offer(value);
        while (!d.isEmpty() && d.peekLast() < value) d.pollLast();
        //note 应该是加到最后
//        d.offer(value);
        d.offerLast(value);
    }

    public int remove() {
        if (q.isEmpty()) return -1;
        int x = q.poll();
        //note 怎么写着写着d就变成了q？
//        if (d.peek() == x) q.poll();
        if (d.peek() == x) d.poll();
        return x;
    }
}