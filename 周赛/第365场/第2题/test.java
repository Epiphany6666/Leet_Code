package 周赛.第365场.第2题;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (i, j) -> (nums[j] - nums[i]));
        int i = 0, j = 0, k = n - 1;
//        while (true) {
//            if (idx[i] < idx[k] && idx[k] < idx[j]) {
//                long ans = (long)(nums[idx[i]] - nums[idx[k]]) * nums[idx[j]];
//                return ans < 0 ? -1 : ans;
//            }
//        }
        for (int l = 0; l < n; l++) {
            for (int m = l + 1; m < n; m++) {
                for (int o = m + 1; o < n; o++) {
                    if (idx[i] < idx[k] && idx[k] < idx[j]) {
                        long ans = (long)(nums[idx[i]] - nums[idx[k]]) * nums[idx[j]];
                        return ans < 0 ? -1 : ans;
                    }
                }
            }
        }
        return -1;
    }
}*/

//固定j，枚举
/*
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int j = 1; j < n - 1; j++) {
            int max1 = nums[0];
            for (int i = 1; i < j - 1; i++) {
                max1 = Math.min(max1, nums[i]);
            }
            int max = nums[n - 1];
            for (int k = j + 1; k < n - 1; k++) {
                max = Math.max(max, nums[k]);
            }
            ans = Math.max(ans, (max1 - nums[j]) * max);
        }
        return ans < 0 ? 0 : ans;
    }
}*/

/*
//method 我承认，这个方法我是真不会，，
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = Integer.MIN_VALUE;
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], nums[i]);
        }

        int prefix = nums[0];
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, (prefix - nums[i]) * suffix[i]);
            prefix = Math.max(prefix, nums[i]);
        }
        return ans < 0 ? 0 : ans;
    }
}*/

//method 2：枚举k，与买卖股票1很像！
/*
class Solution {
    public long maximumTripletValue(int[] nums) {
        long cost = Integer.MIN_VALUE, max = Integer.MIN_VALUE, ans = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            cost = Math.max(cost, nums[i - 2]);
            max = Math.max(max, cost - nums[i - 1]);
            ans = Math.max(ans, max * nums[i]);
        }
        return ans < 0 ? 0 : ans;
    }
}*/

//method 2的第二种写法：灵神的写法
//mind 这样的写法我还是不是很会，还是要多写。。。
class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = Integer.MIN_VALUE;
        int maxDiff = 0, preMax = 0;
        for (int num : nums) {
            ans = Math.max(ans, (long)maxDiff * num);
            maxDiff = Math.max(maxDiff, preMax - num);
            preMax = Math.max(preMax, num);
        }
        return ans < 0 ? 0 : ans;
    }
}