package 周赛.第368场.第1题;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
                ans = Math.min(ans, nums[i - 1] + nums[i] + nums[i + 1]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}*/

//[49,50,48]
//[1,2,1,2]
class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return -1;
        int ans = Integer.MAX_VALUE;
        int[] pre = new int[n + 1];
        Arrays.fill(pre, Integer.MAX_VALUE);
        for (int i = 1; i < n; i++) {
            pre[i] = Math.min(pre[i - 1], nums[i]);
        }
        int suffix = nums[n - 1];
        for (int i = n - 2; i >= 1; i++) {
            if (nums[i] > pre[i] && nums[i] > suffix) {
                ans = Math.min(ans, nums[i] + pre[i] + suffix);
//                suffix = Math.min(suffix, nums[i]);
            }
                suffix = Math.min(suffix, nums[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}