package title.在受污染的二叉树中查找元素1261;


import java.util.HashSet;
import java.util.Set;

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

// method ：自写
class FindElements0 {
    TreeNode root;
    public FindElements0(TreeNode _root) {
        this.root = _root;
        root.val = 0;
        dfs(root);
    }

    private void dfs(TreeNode root) {
        int x = root.val;
        if (root.left != null) {
            root.left.val = 2 * x + 1;
            dfs(root.left);
        }
        if (root.right != null) {
            root.right.val = 2 * x + 2;
            dfs(root.right);
        }
    }

    public boolean find(int target) {
        return dfs2(root, target);
    }

    private boolean dfs2(TreeNode r, int target) {
        if (r == null) return false;
        if (r.val == target) return true;
        return dfs2(r.left, target) || dfs2(r.right, target);
    }
}

/**
 * 参考题解：灵茶山艾府
 */
// method 1：哈希表
class FindElements1 {
    private final Set<Integer> set = new HashSet<>();
    public FindElements1(TreeNode root) {
        dfs(root, 0);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;
        set.add(val);
        dfs(root.left, 2 * val + 1);
        dfs(root.right, 2 * val + 2);
    }
}

// method 2：二进制即路径
class FindElements {
    private TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
    }

    public boolean find(int target) {
        target++;
        TreeNode cur = root;
        for (int i = 30 - Integer.numberOfLeadingZeros(target); i >= 0; i--) {
//            cur.val++; // note 跟污染树的值没关系
            int bit = (target >> i) & 1;
            cur = bit == 0 ? cur.left : cur.right;
            if (cur == null) return false;
        }
        return true;
    }
}