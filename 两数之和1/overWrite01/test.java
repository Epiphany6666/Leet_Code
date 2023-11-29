package title.两数之和1.overWrite01;

import java.util.HashMap;
import java.util.HashSet;

public class test {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) return new int[] {map.get(target - num), i};
            map.put(num, i);
        }
        return new int[0];
    }
}