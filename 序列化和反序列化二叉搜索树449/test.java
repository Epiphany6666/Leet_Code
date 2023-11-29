package title.序列化和反序列化二叉搜索树449;

import java.util.ArrayList;
import java.util.List;

/**
 * 早上做的时候还看不懂题目，今天来看终于看懂了。。。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class test {
}

/*
public class Codec {

    List<Integer> list = new ArrayList<>();
    public String serialize(TreeNode root) {
        dfs1(root);
        StringBuffer sb = new StringBuffer();
        for (Integer i : list) {
            sb.append(i);
        }
        return sb.toString();
    }

    private void dfs1(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");
        return dfs2(0, data.length() - 1, ss);
    }

    private TreeNode dfs2(int left, int right, String[] ss) {
        if (left > right) return null;
        int j = left + 1, t = Integer.parseInt(ss[left]);
        TreeNode ans = new TreeNode(t);
        while (j < right && Integer.parseInt(ss[j]) < t) j++;
        ans.left = dfs2(left, j - 1, ss);
        ans.right = dfs2(j, right, ss);
        return ans;
    }
}
*/


class Codec {
    List<Integer> list = new ArrayList<>();
    public String serialize(TreeNode root) {
        //这步很重要,否则返回的就是空字符串，会影响到下一个方法的结果
        if (root == null) return null;
        dfs1(root);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            int j = list.get(i);
            sb.append(j);
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private void dfs1(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] ss = data.split(",");
        return dfs2(0, ss.length - 1, ss);
    }

    private TreeNode dfs2(int left, int right, String[] ss) {
        if (left > right) return null;
        int j = left + 1, t = Integer.parseInt(ss[left]);
        TreeNode ans = new TreeNode(t);
        while (j <= right && Integer.parseInt(ss[j]) <= t) j++;
        /*ans.left = dfs2(left, j - 1, ss);
        ans.right = dfs2(j, right, ss);*/
        ans.left = dfs2(left + 1, j - 1, ss);
        ans.right = dfs2(j, right, ss);
        return ans;
    }
}
