package title.二叉树的序列化与反序列化297;

import java.util.*;

public class test {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//method 1：BFS
/*
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        StringBuffer sb = new StringBuffer();
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t == null) {
                sb.append("X,");
            } else {
                sb.append(t.val + ",");
                q.offer(t.left);
                q.offer(t.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //特判
        if (data == "") return null;
        Deque<TreeNode> node = new LinkedList<>();
        Deque<String> val = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode root = new TreeNode(Integer.parseInt(val.poll()));
        node.offer(root);
        while (!node.isEmpty()) {
            TreeNode t = node.poll();
            String left = val.poll();
            String right = val.poll();
            //note 要用equals
//            if (left != "X") {
            if (left.equals("X")) {
                t.left = new TreeNode(Integer.parseInt(left));
                node.offer(t.left);
            }
//            if (right != "X") {
            if (right.equals("X")) {
                t.right = new TreeNode(Integer.parseInt(right));
                node.offer(t.right);
            }
        }
        return root;
    }
}*/

//method 2：DFS
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "X,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Queue<String> q = new ArrayDeque<>(Arrays.asList(vals));
        return buildTree(q);
    }

    private TreeNode buildTree(Queue<String> q) {
        String v = q.poll();
        if (v.equals("X")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(v));
        root.left = buildTree(q);
        root.right = buildTree(q);
        return root;
    }
}