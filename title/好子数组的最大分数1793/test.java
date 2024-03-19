package title.好子数组的最大分数1793;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
}

/**
 * 参考题解：cyber_8086
 */
// method ：双指针 + 贪心
class Solution01 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length, l = k, r = k, ans = 0;
        while (true) {
            while (l >= 0 && nums[l] >= nums[k]) l--;
            while (r < n && nums[r] >= nums[k]) r++;
            ans = Math.max(ans, (r - l - 1) * nums[k]);
            if (l < 0 && r >= n) break;
            else if (l < 0) nums[k] = nums[r];
            else if (r >= n) nums[k] = nums[l];
            else nums[k] = Math.max(nums[l], nums[r]);
        }
        return ans;
    }
}

// method 2：优化
class Solution02 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length, l = k, r = k, ans = 0;
        for (int i = nums[k]; i > 0; i--) {
            while (l >= 0 && nums[l] >= i) l--;
            while (r < n && nums[r] >= i) r++;
            ans = Math.max(ans, (r - l - 1) * i);
            if (l < 0 && n >= n) break;
        }
        return ans;
    }
}