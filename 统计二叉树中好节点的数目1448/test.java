package title.统计二叉树中好节点的数目1448;
/**
 * 总结：
 * 1.新学知识点：广度优先遍历如果要一个分支一个分支遍历的话，可以创建两个Deque，然后每个Deque一一对应
 * 2.node总习惯性写成root?，结果还导致错误找了好久
 */

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class test {
}

/*
class Solution {
    int ans = 0;//算上根结点
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return ans;
    }

    private void dfs(TreeNode root, int maxValue) {
        if (root == null) return;
        if (root.val >= maxValue)  {
            ans++;
            maxValue = root.val;
        }

        dfs(root.left, maxValue);
        dfs(root.right, maxValue);
    }
}*/

//dfs - 有返回值
/*class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) return 0;
        int goodNode = root.val >= max ? 1 : 0;
        max = Math.max(max, root.val);
        goodNode += dfs(root.left, max);
        goodNode += dfs(root.right, max);
        return goodNode;
    }
}*/

//法2：广度优先遍历
class Solution {
    public int goodNodes(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        Deque<Integer> maxValDeque = new ArrayDeque<>();

        if (root != null) {
            nodeDeque.offer(root);
            maxValDeque.offer(root.val);
        }

        while (!nodeDeque.isEmpty()) {
            TreeNode node = nodeDeque.poll();//不应该啊，总是把node写成root
            int max = maxValDeque.poll();

            if (node.val >= max) {
                ans++;
                max = Math.max(max, node.val);
            }
            if (node.left != null) {
                nodeDeque.offer(node.left);
                maxValDeque.offer(max);
            }
            if (node.right != null) {
                nodeDeque.offer(node.right);
                maxValDeque.offer(max);
            }
        }
        return ans;
    }
}