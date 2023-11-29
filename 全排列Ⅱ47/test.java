package title.全排列Ⅱ47;

import java.util.*;

public class test {
}

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, path, used);
            path.remove(path.size() - 1);
            used[i] = !used[i];
        }
    }
}