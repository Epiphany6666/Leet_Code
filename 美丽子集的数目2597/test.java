package title.美丽子集的数目2597;

import java.util.HashSet;
import java.util.Set;

public class test {
}

class Solution {
    Set<Integer> set = new HashSet<>();
    int ans = 0;
    public int beautifulSubsets(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            backtrack(nums, 0, i);
        }
        return ans;
    }

    private void backtrack(int[] nums, int begin, int k) {
        if (k == 0) {
            ans++;
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            if (set.contains(nums[i] + k) || set.contains(nums[i] - k)) return;
            set.add(nums[i]);
            backtrack(nums, begin + 1, k - 1);
        }
    }
}