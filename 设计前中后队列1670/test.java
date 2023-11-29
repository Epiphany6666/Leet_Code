package title.设计前中后队列1670;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class test {
}

//method 1：Deque版
class FrontMiddleBackQueue {
    Deque<Integer> l = new ArrayDeque<>(1010), r = new ArrayDeque<>(1010);
    public void pushFront(int val) {
        l.addFirst(val);
        update();
    }

    public void pushMiddle(int val) {
        r.addFirst(val);
        update();
    }

    public void pushBack(int val) {
        r.addLast(val);
        update();
    }

    public int popFront() {
        //note 不能直接这样，因为l可能还为空，l和r还可能同时为空
//        l.pollFirst();
        if (l.isEmpty() && r.isEmpty()) return -1;
        int ans = l.isEmpty() ? r.pollFirst() : l.pollFirst();
        update();
        return ans;
    }

    public int popMiddle() {
        if (l.isEmpty() && r.isEmpty()) return -1;
        int ans = l.size() == r.size() ? l.pollLast() : r.pollFirst();
        update();
        return ans;
    }

    public int popBack() {
        if (l.isEmpty() && r.isEmpty()) return -1;
        //note r不可能为空
//        int ans = r.isEmpty() ? l.pollLast() : r.pollLast();
        int ans = r.pollLast();
        update();
        return ans;
    }

    void update() {
        while (l.size() > r.size()) r.addFirst(l.pollLast());
        while (r.size() > l.size() + 1) l.addLast(r.pollFirst());
    }
}