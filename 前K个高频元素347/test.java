package title.前K个高频元素347;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class test {
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((i, j) -> (j.getValue() - i.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int[] ans = new int[k];
        int idx = 0;
        while (!pq.isEmpty() && idx < k) {
            ans[idx++] = pq.poll().getKey();
        }
        return ans;
    }
}