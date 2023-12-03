package title.执行K次操作后的最大分数2530;

import java.util.Arrays;
import java.util.PriorityQueue;

public class test {
}

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> (j - i));
        for (int num : nums) {
            pq.offer(num);
        }
        long ans = 0;
        while (k-- > 0) {
            int x = pq.poll();
            ans += x;
            pq.offer((x + 2) / 3);
        }
        return ans;
    }
}