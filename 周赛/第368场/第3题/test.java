package 周赛.第368场.第3题;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        new Solution().minGroupsForValidAssignment(new int[] {3, 2, 3, 2, 3});
    }
}

class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        for (Integer i : map.values()) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int count = 0;
        for (Integer i : map.values()) {
            if (i > min + 1) {
                count += (i + min) / (min + 1) - 1;
            }
        }
        int size = map.size();
//        return max - min <= 1 ? size : size + (max + min) / (min + 1) - 1;
        if (max - min <= 1) return size;
        return size + count;
    }
}