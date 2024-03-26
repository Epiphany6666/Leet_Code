package com.Arrays.两数之和1;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int target = 6;
        new Solution().twoSum(nums, target);
    }
}

/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = 2;
        int[] ans = new int[length];
        boolean[] used = new boolean[nums.length];
        int sum = 0;
        boolean[] answer.md = new boolean[1];
        addSum(ans, nums, length, used, 0, target, sum, answer.md);
        return ans;
    }
    public void addSum(int[] ans, int[] nums, int length, boolean[] used, int depth, int target, int sum, boolean[] answer.md) {
        if (depth == length) {
            if (sum == target) answer.md[0] = true;
            return;
        }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i] && !answer.md[0]) {
                    ans[depth] = i;
                    sum += nums[i];
                    used[i] = true;
                    addSum(ans, nums, length, used, depth + 1, target, sum, answer.md);
                    used[i] = false;
                    sum -= nums[i];///////一定要记得减去
                }
            }
    }
}*/

/*//法一：暴力，简写
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[] {i, j};
            }
        }
        return new int[0];
    }
}*/

//法二：哈希表
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++)  {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[] {i, hashTable.get(target - nums[i])};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }
}