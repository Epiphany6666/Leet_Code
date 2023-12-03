package title.子集78.overWrite;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        new Solution().subsets(new int[] {1, 2, 3});
    }
}

/*//回溯
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            dfs(ans, nums, i, new ArrayDeque<Integer>());
        }
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, int depth, Deque<Integer> path) {
//        if (depth == nums.length) {
        ans.add(new ArrayList<>(path));
        if (depth == nums.length) {//等于length的时候还是要再进来一次。
            return;
        }

        path.addLast(nums[depth]);
        dfs(ans, nums, depth + 1, path);
        path.removeLast();
    }
}*/

/**
 * 我有点不知道自己在写一些什么代码了。。。
 * 没有思路，犯低级错误。。。
 */
/*class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        ans.add(new ArrayList<Integer>());
        for (int i = 0; i < n; i++) {
            backtrack(ans, nums, i, new ArrayDeque<Integer>());
        }
    }

    private void backtrack(List<List<Integer>> ans, int[] nums, int depth, Deque<Integer> path) {
        if (depth == nums.length) return;

        for (int i = depth; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrack(ans, nums, depth + 1, path);
            path.removeLast();
        }
    }
}*/

/**
 * 明明那么简单的回溯，为什么我会想这么久，用这么多时间去琢磨，我脑子到底怎么想的
 */
/*class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
//        ans.add(new ArrayList<Integer>());//这里也没有必要再重新添加一个
        for (int i = 0; i <= n; i++) {
            backtrack(0, ans, nums, i, new ArrayDeque<Integer>());
        }
        return ans;
    }

    private void backtrack(int start, List<List<Integer>> ans, int[] nums, int k, Deque<Integer> path) {
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
//            backtrack(start + 1, ans, nums, k - 1, path);
            backtrack(i + 1, ans, nums, k - 1, path);//这里不是start+1，而是i+1
            path.removeLast();
        }
    }
}*/


/*//递归，写法1
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num : nums) {
            *//**
 * 这种做法绝对错误。
 * 如果list里面是引用类型的数据，则拷贝的时候，拷贝的是同一个对象！！！！
 * 也算是明白了力扣官方题解里为什么要这么大费周章了
 *//*
//            List<List<Integer>> newSubsets = new ArrayList<>(ans);
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
}*/

/**递归写法2*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return dfs(nums.length, nums);
    }

    public List<List<Integer>> dfs(int cur, int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (cur == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> existing_result = dfs(cur - 1, nums);
        result.addAll(existing_result);

        for (List<Integer> exist : existing_result) {
            List<Integer> newSubset = new ArrayList<>(exist);
            newSubset.add(nums[cur - 1]);
            result.add(newSubset);
        }
        return result;
    }
}