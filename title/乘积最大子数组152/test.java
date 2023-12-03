package title.乘积最大子数组152;

public class test {
}

/*
class Solution {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], dp[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}*/

//note 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin。
class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = min;
                min = max;
                max = t;
            }
            min = Math.min(min * nums[i], nums[i]);
            max = Math.max(max * nums[i], nums[i]);

            ans = Math.max(ans, max);
        }
        return ans;
    }
}