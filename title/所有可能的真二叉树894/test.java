package title.所有可能的真二叉树894;

import java.util.ArrayList;
import java.util.List;

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

/**
 * 参考题解：ylb
 */
// method 记忆化搜索
class Solution {
    List<TreeNode>[] f;
    public List<TreeNode> allPossibleFBT(int n) {
        f = new List[n + 1];
        return dfs(n);
    }

    private List<TreeNode> dfs(int n) {
        if (f[n] != null) return f[n];
        if (n == 1) return List.of(new TreeNode());
        List<TreeNode> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int j = n - i - 1;
            for (TreeNode left : dfs(i)) {
                for (TreeNode right : dfs(j)) {
                    ans.add(new TreeNode(0, left, right));
                }
            }
        }
        f[n] = ans;
        return f[n];
    }
}