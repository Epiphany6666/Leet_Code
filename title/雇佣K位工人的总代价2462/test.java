package title.雇佣K位工人的总代价2462;

import java.util.*;

public class test {
}

/*
//mind 最开始就没看懂题目。。。
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        Deque<Integer> q = new LinkedList<>();
        int n = costs.length;
        long ans = 0;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            q.offer(costs[i]);
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> (costs[i] == costs[j] ? Math.min(i, j) : costs[i] - costs[j]));

    }
}*/

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> front = new PriorityQueue<>();
        PriorityQueue<Integer> rear = new PriorityQueue<>();
        long ans = 0;
        int i = 0, j = costs.length - 1;

        while (k-- > 0) {
            while (front.size() < candidates && i <= j) front.offer(costs[i++]);
            while (rear.size() < candidates && i <= j) rear.offer(costs[j--]);
            int x = front.isEmpty() ? Integer.MAX_VALUE : front.peek();
            int y = rear.isEmpty() ? Integer.MAX_VALUE : rear.peek();
            if (x <= y) {
                ans += front.poll();
            } else {
                ans += rear.poll();
            }
        }
        return ans;
    }
}