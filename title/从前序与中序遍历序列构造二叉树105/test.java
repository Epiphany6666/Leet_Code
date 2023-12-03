package title.从前序与中序遍历序列构造二叉树105;

import java.util.Arrays;

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

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                int[] preorder_left = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preorder_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] inorder_left = Arrays.copyOfRange(preorder, 0, i);
                int[] inorder_right = Arrays.copyOfRange(preorder, i + 1, inorder.length);
                //总是粗心写错啊，，，
//                root.left = buildTree(preorder_left, inorder_left);
//                root.right = buildTree(preorder_right, inorder_right);
                root.left = buildTree(inorder_left, inorder_left);
                root.right = buildTree(inorder_right, inorder_right);
                break;
            }
        }
        return root;
    }
}