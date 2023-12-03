package title.打家劫舍Ⅳ2560.overWrite01;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public int minCapability(int[] nums, int k) {
        int r = Arrays.stream(nums).max().getAsInt();
        int l = Arrays.stream(nums).min().getAsInt();
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (check(nums, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean check(int[] nums, int mid, int k) {
        int f0 = 0, f1 = 0;
        for (int num : nums) {
//            if (num > k) {
            if (num > mid) {
                f0 = f1;
            } else {
                int t = f1;
                f1 = Math.max(f0 + 1, f1);
//                f0 = f1;
                f0 = t;
            }
        }
        return f1 >= k;
    }
}*/

//method 2：贪心 - 能偷则偷
class Solution {
    public int minCapability(int[] nums, int k) {
        int l = Arrays.stream(nums).min().getAsInt();
        int r = Arrays.stream(nums).max().getAsInt();

        while (l <= r) {
            int mid = l + ((r - l) >> 2);
            if (check(nums, mid, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int mid, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num <= mid) {
                cnt++;
                i++;
            }
        }
        return cnt >= k;
    }
}
