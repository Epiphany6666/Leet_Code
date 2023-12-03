package 双周赛.第116场双周赛.第3题;

import java.util.Arrays;
import java.util.List;

public class test {
}

/*
class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;
            for (int j = i; j < nums.size(); j++) {
                sum += nums.get(j);
                if (sum == target) ans++;
                if (sum > target) break;
            }
        }
        return ans;
    }
}*/

class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] f = new int[target + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        int s = 0;
        for (Integer num : nums) {
            s = Math.min(s + num, target);
            for (int i = s; i >= num; i++) {
                f[i] = Math.max(f[i], f[i - num] + 1);
            }
        }
        return f[target] > 0 ? f[target] : -1;
    }
}