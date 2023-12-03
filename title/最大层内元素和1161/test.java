package title.最大层内元素和1161;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
    }
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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return -1;
        int ans = -1;
        int sum = -1;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //note 看清题目，应该从0开始
//        int idx = -1;
        int idx = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int s = 0;
            idx++;
            while (size-- > 0) {
                TreeNode t = q.poll();
                s += t.val;
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            if (s > sum) {
                ans = idx;
                sum = s;
            }
        }
        return ans;
    }
}*/

//method 2：深度优先遍历
class Solution {
    List<Integer> list = new ArrayList<>();
    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(ans)) ans = i;
        }
        return ans + 1;
    }

    private void dfs(TreeNode root, int depth) {
        if (depth == list.size()) list.add(root.val);
        else {
            list.set(depth, list.get(depth) + root.val);
        }
        if (root.left != null) dfs(root.left, depth + 1);
        if (root.right != null) dfs(root.right, depth + 1);
    }
}