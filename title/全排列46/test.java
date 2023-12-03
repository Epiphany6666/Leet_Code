package com.Arrays.全排列46;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        new Solution().permute(new int[]{1,2,3});
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        Deque<Integer> path = new LinkedList<>();
        boolean used[] = new boolean[length];
        DFS(ans, nums, length, 0, path, used);
        return ans;
    }

    private void DFS(List<List<Integer>> ans, int[] nums, int length, int depth, Deque<Integer> path, boolean[] used) {
        if (depth == length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                DFS(ans, nums, length, depth + 1, path, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}