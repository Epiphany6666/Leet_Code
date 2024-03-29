package 周赛.第368场.元素和最小的山形三元组I2908.overWrite01;

public class test {
}

// method 1：暴力
class Solution1 {
    public int minimumSum(int[] nums) {
        int ans = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j]) ans = Math.min(ans, nums[i] + nums[j] + nums[k]);
                }
            }
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}

/**
 * 参考题解：灵茶山艾府
 */
// method 2：
class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i > 1; i--) {
            suf[i] = Math.min(nums[i], suf[i + 1]);
        }
        int pre = nums[0];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            if (pre < nums[i] && nums[i] > suf[i + 1]) {
                ans = Math.min(ans, nums[i] + pre + suf[i + 1]);
            }
            pre = Math.min(pre, nums[i]);
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}