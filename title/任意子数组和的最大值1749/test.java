package title.任意子数组和的最大值1749;

public class test {
    public static void main(String[] args) {
        new Solution().maxAbsoluteSum(new int[]{-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9});
    }
}
//有负有正的情况下怎么能一起求呢？？？
/*
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = Math.abs(nums[0]);
        for (int i = 1; i < n; i++) {
            int x = dp[i - 1] + nums[i];
            dp[i] = Math.abs(x) > Math.abs(nums[i]) ? x : nums[i];
            ans = Math.max(ans, Math.abs(dp[i]));
        }
        return ans;
    }
}*/

/**复杂太多了！！！*/
/*class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = nums[0];
        dp2[0] = nums[0];
        int max = Integer.MIN_VALUE;
        int min = 0x3f3f3f3f;
//        int ans = Math.abs(nums[0]);
        for (int i = 1; i < n; i++) {
            int x = dp1[i - 1] + nums[i];
            dp1[i] = Math.max(x, nums[i]);
            max = Math.max(max, dp1[i]);
//            ans = Math.max(ans, Math.abs(dp1[i]));
            int x2 = dp2[i - 1] + nums[i];
            dp2[i] = Math.min(x2, nums[i]);
            min = Math.min(min, dp2[i]);
        }
        ans = Math.max(Math.abs(Math.max(max,dp1[0])), Math.abs(Math.min(min, dp2[0])));
        return ans;
    }
}*/

/*
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int positiveMax = 0, negativeMin = 0;
        int positiveSum = 0, negativeSum = 0;
        for (int i : nums) {
            positiveSum = Math.max(positiveMax + i, i);
            positiveMax = Math.max(positiveMax, positiveSum);
            negativeSum = Math.min(negativeMin + i, i);
            negativeMin = Math.min(negativeSum, negativeMin);
        }
        return Math.max(Math.abs(positiveMax), Math.abs(negativeMin));
    }
}*/

/*
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int fMax = 0, fMin = 0, ans = 0;
        for (int num : nums) {
            fMax = Math.max(fMax, 0) + num;
            fMin = Math.min(fMin, 0) + num;
            ans = Math.max(ans, Math.max(fMax, -fMin));
        }
        return ans;
    }
}*/

//法2：前缀和
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0, max = 0, min = 0;
        for (int num : nums) {
            sum += num;
            if (sum > max) max = sum;
            else if (sum < min) min = sum;
        }
        return max - min;
    }
}