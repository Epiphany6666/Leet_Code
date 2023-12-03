package title.无限集中的最小数字2336.overWrite01;

import java.util.PriorityQueue;

public class test {
}

class SmallestInfiniteSet {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public SmallestInfiniteSet() {
        for (int i = 1; i <= 1000; i++) {
            pq.offer(i);
        }
    }

    public int popSmallest() {
        return pq.poll();
    }

    public void addBack(int num) {
        if (!pq.contains(num)) pq.offer(num);
    }
}