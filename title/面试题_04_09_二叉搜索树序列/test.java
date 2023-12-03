package title.面试题_04_09_二叉搜索树序列;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/*
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> BSTSequences(TreeNode root) {
        ans = new ArrayList<>();
        if (root == null) {
            //如果ans为空，返回一个空列表
            ans.add(new ArrayList<>());
            return ans;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> path = new ArrayList<>();
        dfs(q, path);
        return ans;
    }

    private void dfs(Deque<TreeNode> q, List<Integer> path) {
        if (q.isEmpty()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        int size = q.size();
        while (size-- > 0) {
            TreeNode t = q.poll();
            if (t.left != null) q.offer(t.left);
            if (t.right != null) q.offer(t.right);
            path.add(t.val);
            dfs(q, path);
            path.remove(path.size() - 1);
//            q = copy;
//            q = new LinkedList<>(copy);
            q.offer(t);
        }
    }
}*/

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> BSTSequences(TreeNode root) {
        ans = new ArrayList<>();
        if (root == null) {
            //如果ans为空，返回一个空列表
            ans.add(new ArrayList<>());
            return ans;
        }

        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        List<Integer> path = new ArrayList<>();
        dfs(q, path);
        return ans;
    }

    private void dfs(List<TreeNode> q, List<Integer> path) {
        if (q.isEmpty()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        List<TreeNode> copy = new ArrayList<>(q);

        int size = q.size();
        for (int i = 0; i < size; i++) {
            TreeNode t = q.get(i);
            if (t.left != null) q.add(t.left);
            if (t.right != null) q.add(t.right);
            path.add(t.val);
            q.remove(t);
            dfs(q, path);
            path.remove(path.size() - 1);
            //note 这里不可以直接等于
//            q = copy;
//            q = new LinkedList<>(copy);
            q = new ArrayList<>(copy);
        }
    }
}