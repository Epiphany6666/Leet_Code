package title.使数组和小于等于x的最少时间2809;

import java.util.Arrays;
import java.util.List;

public class test {
}

class Solution {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int[][] nums = new int[n][0];
        for (int i = 0; i < n; i++) {
            nums[i] = new int[] {nums1.get(i), nums2.get(i)};
        }
        Arrays.sort(nums, (i, j) -> (i[1] - j[1]));
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j] = f[i - 1][j];
                if (j > 0) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + nums[i - 1][0] + nums[i - 1][1] * j);
                }
            }
        }

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums[i][0];
            sum2 += nums[i][1];
        }
        for (int i = 0; i <= n; i++) {
            if (sum1 + sum2 * i - f[n][i] <= x) return i;
        }
        return -1;
    }
}