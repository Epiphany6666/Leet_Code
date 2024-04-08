package title.检查数组是否经排序和轮转得到1752;

import java.util.Arrays;

public class test {
}

/**
 * 参考题解：
 */
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= nums[(i + 1) % n]) {
                cnt++;
            }
        }
        return cnt <= 1;
    }
}