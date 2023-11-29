package title.全排列46.overWrite01;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test {
}

//method 1：深度优先遍历
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(nums, 0, new ArrayList<>(), used);
        return ans;
    }

    private void dfs(int[] nums, int depth, ArrayList<Integer> path, boolean[] used) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, path, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}

/*
//method 2：DFS
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        int len = nums.length;
        Deque<Integer> q = new LinkedList<>();
        q.offer(nums[0]);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {

            }
        }
    }
}*/
