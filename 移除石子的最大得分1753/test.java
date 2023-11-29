package title.移除石子的最大得分1753;

import java.util.PriorityQueue;

public class test {
}

class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> (j - i));
        int ans = 0;
        if (a > 0) pq.offer(a);
        if (b > 0) pq.offer(b);
        if (c > 0) pq.offer(c);
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            ans++;
            if (--x > 0) pq.offer(x);
            if (--y > 0) pq.offer(y);
        }
        return ans;
    }
}
