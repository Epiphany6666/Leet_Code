package title.反转二叉树的奇数层2415;

import com.sun.source.tree.Tree;

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

//method 1：BFS
//mind 每次自己写的都好垃圾。。。
/*
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        List<TreeNode> list = new ArrayList<>();
        boolean flag = false;
        TreeNode ans = null;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode tmp = q.poll();
                if (!flag) {
                    list.add(tmp);
                } else {
                    list.add(0, tmp);
                }
                if (tmp.left != null) {
                    q.offer(tmp.left);
                    q.offer(tmp.right);
                }
            }
        }

        for (TreeNode treeNode : list) {
            if (ans == null) ans = new TreeNode(root.val);
            else {
                if ()
            }
        }
        return ans;
    }
}*/

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean isOdd = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> arr = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (isOdd) {
                    arr.add(node);
                }
                if (node.left != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if (isOdd) {
                for (int l = 0, r = size - 1; l < r; l++, r--) {
                    int temp = arr.get(l).val;
                    arr.get(l).val = arr.get(r).val;
                    arr.get(r).val = temp;
                }
            }
            isOdd ^= true;
        }
        return root;
    }
}