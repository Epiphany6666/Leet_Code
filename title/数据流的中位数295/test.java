package title.数据流的中位数295;

import java.util.PriorityQueue;

public class test {
}

class MedianFinder {
    PriorityQueue<Integer> l = new PriorityQueue<>((i, j) -> (j - i));
    PriorityQueue<Integer> r = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (l.size() == r.size()) {
            if (r.isEmpty() || num <= r.peek()) {
                l.add(num);
            } else {
                l.add(r.peek());
                r.add(num);
            }
        } else {
            if (l.isEmpty() || num >= l.peek()) {
                r.add(num);
            } else {
                r.add(l.peek());
                l.add(num);
            }
        }
    }

    public double findMedian() {
        return l.size() == r.size() ? (l.peek() + r.peek()) / 2.0 : l.peek();
    }
}