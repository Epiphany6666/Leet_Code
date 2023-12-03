package 无限集中的最小数字2336;

import java.util.HashSet;
import java.util.PriorityQueue;

public class test {
}

/**
 * 如果不使用contains方法，可以使用set或者boolean数组标记，因为set如果添加不成功就会返回false
 */
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