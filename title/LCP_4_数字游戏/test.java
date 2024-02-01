package title.LCP_4_数字游戏;

import java.util.PriorityQueue;

public class test {
}

// method 灵神题解结合官网题解
class Solution {
    public int[] numsGame(int[] nums) {
        final int MOD = 1_000_000_007;
        PriorityQueue<Integer> left = new PriorityQueue<>((i, j) -> (j - i));
        PriorityQueue<Integer> right = new PriorityQueue<>((i, j) -> (i - j));
        int n = nums.length;
        int[] ans = new int[n];
        // note 越界
//        int rightSum = 0, leftSum = 0;
        long rightSum = 0, leftSum = 0;
        for (int i = 0; i < n; i++) {
            int b = nums[i] - i;
            if (left.size() == right.size()) {
                right.offer(b);
                rightSum += b;
                left.offer(right.peek());
                leftSum += right.peek();
                rightSum -= right.poll();
            } else {
                left.offer(b);
                leftSum += b;
                right.offer(left.peek());
                leftSum -= left.peek();
                rightSum += left.poll();
            }
            if (i % 2 == 0) { // 奇数
                ans[i] = (int) ((rightSum - leftSum - left.peek()) % MOD);
            } else { // 偶数
                ans[i] = (int) ((rightSum - leftSum) % MOD);
            }
        }
        return ans;
    }
}