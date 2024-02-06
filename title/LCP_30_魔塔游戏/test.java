package title.LCP_30_魔塔游戏;

import java.util.PriorityQueue;

public class test {
}

class Solution {
    public int magicTower(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        long hp = 1;
        for (int num : nums) {
            if (num < 0) pq.offer(num);
            hp += num;
            if (hp < 1) {
                hp -= pq.poll();
                ans++;
            }
        }
        return ans;
    }
}