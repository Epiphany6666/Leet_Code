package title.最大子序列的分数2542;

import java.util.Arrays;
import java.util.PriorityQueue;

public class test {
}

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums2.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> (nums2[j] - nums2[i]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum1 = 0;
        for (int i = 0; i < k - 1; i++) {
            int id = idx[i];
            sum1 += nums1[id];
            pq.offer(nums1[id]);
        }

        //note 返回的是long，为什么又没注意
//        int ans = 0;
        int ans = 0;
        for (int i = k - 1; i < n; i++) {
            int id = idx[i];
            sum1 += nums1[id];
            ans = Math.max(ans, sum1 * nums2[id]);
            sum1 -= pq.poll();
            pq.offer(nums1[id]);
        }
        return ans;
    }
}