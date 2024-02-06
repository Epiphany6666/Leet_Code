package title.跳跃游戏VI1696;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class test {
}

//method 1：动态规划加优先队列优化
class Solution1 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
//        Deque<int[]> q = new ArrayDeque<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> (j[0] - i[0]));
        pq.offer(new int[]{nums[0], 0});
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            while (i - pq.peek()[1] > k) pq.poll();
            ans = pq.peek()[0] + nums[i];
            pq.offer(new int[]{ans, i});
        }
        return ans;
    }
}

//method 2：动态规划 + 单调队列优化
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[] {nums[0], 0});
//        int ans = 0;
        int ans = nums[0]; // note 因为它有可能只有一个元素;
        for (int i = 1; i < n; i++) {
            while (i - q.peek()[1] > k) {
                q.poll();
            }
            ans = q.peek()[0] + nums[i];
            while (!q.isEmpty() && ans >= q.peekLast()[0]) {
                q.pollLast();
            }
            q.offerLast(new int[] {ans, i});
        }
        return ans;
    }
}