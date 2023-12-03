package title.对称二叉树101;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LinkedList可以存放空，但是ArrayList不行！
 * ArrayDeque和LinkList区别：
 * ArrayDeque：
 * 数组结构
 * 插入元素不能为null
 * 无法确定数据量时，后期扩容会影响效率
 *
 * LinkList：
 * 链表结构
 * 插入元素能为null
 * 无法确定数据量时，有更好表现
 */

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
//mind 这题也写的完全不沾边啊。。，，
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        boolean l = isSymmetric(root.left);
        boolean r = isSymmetric(root.right);
        if (root.left != null && root.right != null && root.left.val != root.right.val) {
            return false;
        }
        return l && r;
    }
}*/

/*
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.right, root.left);
    }

    private boolean dfs(TreeNode right, TreeNode left) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return dfs(right.left, right.right) && dfs(left.left, left.right);
    }
}*/

//method 2：队列实现
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
}