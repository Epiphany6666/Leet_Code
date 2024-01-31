package title.找出不同元素数目差数组2670;

import java.util.HashSet;
import java.util.Set;

public class test {
}

class Solution1 {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> s1 = new HashSet<>();
            Set<Integer> s2 = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                s1.add(nums[j]);
            }
            for (int j = i + 1; j < n; j++) {
                s2.add(nums[j]);
            }
            diff[i] = s1.size() - s2.size();
        }
        return diff;
    }
}

//method 参考灵神：前后缀
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = n - 1; i > 0; i--) {
            set.add(nums[i]);
            suf[i] = set.size();
        }
        set.clear();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            ans[i] = set.size() - suf[i + 1];
        }
        return ans;
    }
}