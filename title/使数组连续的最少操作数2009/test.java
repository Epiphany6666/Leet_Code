package title.使数组连续的最少操作数2009;

import java.util.*;

public class test {
}

/**
 * 参考题解：力扣官方题解
 */
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> setSort = new ArrayList<>(set);
        Collections.sort(setSort);
        int j = 0;
        int ans = n;
        for (int i = 0; i < set.size(); i++) {
            int left = setSort.get(i);
            int right = left + n - 1;
            while (j < setSort.size() && setSort.get(j) <= right) {
                ans = Math.min(ans, n - (j - i + 1));
                j++;
            }
        }
        return ans;
    }
}