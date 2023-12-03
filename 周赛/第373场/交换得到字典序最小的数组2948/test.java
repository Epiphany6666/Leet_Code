package 周赛.第373场.交换得到字典序最小的数组2948;

import java.util.Arrays;

public class test {
}

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> (nums[i] - nums[j]));

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int st = i;
            for (i++; i < n && nums[ids[i]] - nums[ids[i - 1]] < limit; i++);
            Integer[] sub = Arrays.copyOfRange(ids, st, i);
            Arrays.sort(sub);
            for (int j = 0; j < sub.length; j++) {
                ans[sub[j]] = nums[ids[st + j]];
            }
        }
        return ans;
    }
}
