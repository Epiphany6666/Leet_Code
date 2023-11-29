package title.最长递增子序列300.overWrite01;

import java.util.Arrays;

public class test {
}

//method 1：动态规划
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return f[n - 1];
    }
}*/

//method 2：贪心+二分
class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] tail = new int[nums.length];
        for (int num : nums) {
            int l = 0, r = ans;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (tail[mid] < num) l = mid + 1;
                else r = mid - 1;
            }
            if (l == ans) ans++;
            tail[l] = num;
        }
        return ans;
    }
}