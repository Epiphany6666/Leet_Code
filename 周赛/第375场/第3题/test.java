package 周赛.第375场.第3题;

import java.util.Arrays;

public class test {
}

class Solution2 {
    public long countSubarrays(int[] nums, int k) {
        int ans = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int cnt = 0;
        int n = nums.length;
        for (int i = 0, j = 0; j < n; j++) {
            if (nums[j] == max) cnt++;
            if (cnt >= k) ans += n - j;
            while (i < j && cnt >= k) {
                i++;
                if (nums[i] == k) cnt--;
                if (cnt >= k) ans += n - j;
            }
        }
        return ans;
    }
}

class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int cnt = 0;
        int n = nums.length;
        for (int i = 0, j = 0; j < n; j++) {
            if (nums[j] == max) cnt++;
            if (cnt >= k) ans += (n - j);
            //question 这里不理解
            while (i <= j && cnt >= k) {
                if (nums[i] == max) cnt--;
                i++;
                if (cnt >= k) ans += n - j;
            }
        }
        return ans;
    }
}