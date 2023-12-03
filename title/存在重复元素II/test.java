package title.存在重复元素II;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test {
}

//method 1：暴力
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j - i <= k && j < len; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}

/**
 * 这种关系我总是乱乱的，，，
 * abs(i - j) <= k实际上是有九个元素的。。
 */
//method 2：滑动窗口
class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
//            if (set.size() >= k) set.remove(nums[i - k]);
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }
}

//method 3：哈希表
class Solution3 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}