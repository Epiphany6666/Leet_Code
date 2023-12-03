package title.统计和小于目标的下标对数目2824;

import java.util.Collections;
import java.util.List;

public class test {
}

/*
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int size = nums.size(), ans = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums.get(i) + nums.get(j) < target) ans++;
            }
        }
        return ans;
    }
}*/

//method 2：双指针
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int left = 0, right = nums.size(), ans = 0;
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                ans += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}