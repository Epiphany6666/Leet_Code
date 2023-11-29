package title.从数量最多的堆取走礼物2558;

import java.util.PriorityQueue;

public class test {
}

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> (j = i));
        for (int gift : gifts) {
            pq.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            pq.offer((int)Math.sqrt(pq.poll()));
        }
        long ans = 0;
        for (Integer num : pq) {
            ans += num;
        }
        return ans;
    }
}