package title.和相等的子数组2395;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 总结：
 * set.add()的返回值：如果此集合已包含该元素，则调用将保留该集合不变并返回 false。
 */
public class test {
}

/*
class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != n - 1 && j != n - 1 && nums[i] + nums[i + 1] == nums[j] + nums[j + 1]) return true;
            }
        }
        return false;
    }
}*/

class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length -  1; i++) {
            int sum = nums[i] + nums[i + 1];
            /*if (set.contains(sum)) return true;
            set.add(sum);*/
            //note 简写：
            if (!set.add(sum)) {
                return true;
            }
        }
        return false;
    }
}