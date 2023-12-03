package title.子集78.overWrite02;

import java.util.ArrayList;
import java.util.List;

public class test {
}

/*
//mind 你这种写法不能说跟正确解法一模一样，只能说完全不沾边
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, 0, new ArrayList<>());
        }
        return ans;
    }

    private void dfs(int[] nums, int depth, List<Integer> path) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = depth; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}*/


//method 1：递归
//mind 好烦，以前做过的题，现在又不会了
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : ans) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            ans.addAll(newSubsets);
        }
        return ans;
    }
}