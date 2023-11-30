package title.二叉树的锯齿型层序遍历103;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

//method 错误解法。。。看看我自己写的什么垃圾代码
/*
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            TreeNode tmp;
            if (flag)  {
                while (size-- > 0) {
                    tmp = q.pollFirst();
                    list.add(tmp.val);
                    if (tmp.left != null) q.offer(tmp.left);
                    if (tmp.right != null) q.offer(tmp.right);
                }
            } else {
                while (size-- > 0) {
                    tmp = q.pollLast();
                    list.add(tmp.val);
                    if (tmp.left != null) q.offer(tmp.left);
                    if (tmp.right != null) q.offer(tmp.right);
                }
            }
            flag = !flag;
            ans.add(list);
        }
        return ans;
    }
}*/

/**
 * 还看到另一种做法，先当成普通的层次遍历，然后再使用Collection.reverse反转链表
 */

/**
 * 简洁做法还是得看大神，根本不需要分情况讨论
 * 可以使用 list.add(0, tmp.val); 添加到首端
 */
//method 1：BFS
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode tmp = q.poll();
                if (flag) {
                    list.add(tmp.val);
                } else {
                    list.add(0, tmp.val);
                }
                if (tmp.left != null) q.offer(tmp.left);
                if (tmp.right != null) q.offer(tmp.right);
            }
        flag = !flag;
        ans.add(list);
        }
        return ans;
    }
}

//method 2：DFS
class Solution2 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (ans.size() == depth) {
            ans.add(new ArrayList<>());
        }
        List<Integer> list = ans.get(depth);
        if (depth % 2 == 0) {
            list.add(root.val);
        } else {
            list.add(0, root.val);
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}