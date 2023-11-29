package title.路径总和Ⅲ437;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/*
class Solution {
    int ans = 0;
    Map<TreeNode, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }

    private int dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int r = root.val;
        if (map.containsKey(root)) {
            r = map.get(root);
            if (r == targetSum) ans++;
            return r;
        }
        r += dfs(root.left, targetSum);
        r += dfs(root.right, targetSum);
        map.put(root, r);
        if (r == targetSum) ans++;
        return map.get(root);
    }
}*/

//mind 又误解错题目意思了，这个路径不一定要从叶子结点开始啊。。。
//mind 终于悟出了这道题的难点了。。。它可以从任意地方开始
/*
class Solution {
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        dfs(root, targetSum);
        //note 解决方案
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        //note 这里相减可能会造成越界问题，把targetSum改为long发现就可以过了
        if (targetSum - root.val == 0) {
            ans++;
            //note 这里不能直接return，因为结点的值有可能是负数！！！
//            return;
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
    }
}*/

//method 2：递归带返回值的
/*class Solution {
    public int pathSum(TreeNode root, int targetSum) {

    }
}*/

//method 3：前缀和
//mind 能想出这种解法的人真的好牛逼
/*
class Solution {
    int ans = 0;
    int t = 0;
    Map<Integer, Integer> map = new HashMap<>();//前缀和 - 个数
    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        //前缀和为0的有一个结点
        map.put(0, 1);
        recursionPathSum(root, 0);
        return ans;
    }

    private void recursionPathSum(TreeNode root, int preSum) {
        if (root == null) return;
        preSum += root.val;
//        ans += map.get(preSum - t);
        ans += map.getOrDefault(preSum - t, 0);
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        recursionPathSum(root.left, preSum);
        recursionPathSum(root.right, preSum);
        map.put(preSum, map.get(preSum) - 1);
    }
}*/

//增加测试用例之后要改为long了
class Solution {
    int ans = 0;
    long t = 0;
    Map<Long, Integer> map = new HashMap<>();//前缀和 - 个数
    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        //前缀和为0的有一个结点
        map.put(0L, 1);
        recursionPathSum(root, 0);
        return ans;
    }

    private void recursionPathSum(TreeNode root, long preSum) {
        if (root == null) return;
        preSum += root.val;
        ans += map.getOrDefault(preSum - t, 0);
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        recursionPathSum(root.left, preSum);
        recursionPathSum(root.right, preSum);
        map.put(preSum, map.get(preSum) - 1);
    }
}