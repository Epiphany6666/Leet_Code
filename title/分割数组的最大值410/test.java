package title.分割数组的最大值410;

import java.util.Arrays;

public class test {
}

//method 1：动态规划
class Solution1 {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][1] = pre[i + 1];
        }
        for (int m = 2; m <= n; m++) {
            for (int i = m - 1; i < n; i++) {
                for (int j = m - 2; j < i; j++) {
                    dp[i][m] = Math.min(dp[i][m], Math.max(dp[j][m - 1], pre[i + 1] - pre[j + 1]));
                }
            }
        }
        return dp[n - 1][k];
    }
}

//method 2：二分
class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int splits = split(nums, mid);
            if (splits > k) {
                left = mid + 1;
             } else {
                right = mid;
            }
        }
        return left;
    }

    private int split(int[] nums, int max) {
//        int split = 0, cur = 0;
        // note 至少是一个分割
        int split = 1, cur = 0;
        for (int num : nums) {
            if (cur > max) {
                cur = 0;
                split++;
            }
            cur += num;
        }
        return split;
    }
}