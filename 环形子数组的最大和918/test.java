package title.环形子数组的最大和918;

public class test {
    public static void main(String[] args) {
        new Solution().maxSubarraySumCircular(new int[] {1, 2});
    }
}

/*//法1：暴力
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len + i; j++) {
                int temp = (j + 1) % len;
                sum += nums[temp];
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}*/

/*
//法2:动态规划
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i]);
            res = Math.max(res, dp[i]);
        }
        dp[0] = Math.max(dp[len - 1], dp[0]);
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}*/

/*
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int[] dp1 = new int[len];
        dp1[0] = nums[0];
        int[] dp2 = new int[len];
        dp2[0] = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        int numsSum = nums[0];
        for (int i = 1; i < len; i++) {
            dp1[i] = Math.min(dp1[i - 1] + dp1[i], dp1[i]);
            minSum = Math.min(minSum, dp1[i]);
            dp2[i] = Math.max(dp2[i - 1] + dp2[i], dp2[i]);
            maxSum = Math.max(minSum, dp2[i]);
            numsSum += nums[i];
        }
        return numsSum == maxSum ? maxSum : Math.max(numsSum - minSum, maxSum);
    }
}*/

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxS = Integer.MIN_VALUE;
        int minS = 0;
        int maxF = 0, minF = 0, sum = 0;
        for (int x : nums) {
            maxF = Math.max(maxF, 0) + x;
            maxS = Math.max(maxS, maxF);
            minF = Math.min(minF, 0) + x;
            minS = Math.min(minS, minF);
            sum += x;
        }
        return sum == minS ? maxS : Math.max(maxS, sum - minS);
    }
}

