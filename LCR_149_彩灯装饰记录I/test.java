package title.LCR_149_彩灯装饰记录I;

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
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int[] decorateRecord(TreeNode root) {
        if (root == null) return new int[0];
        Deque<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.offer(root);
//        while (!q.isEmpty()) {
//            int size = q.size();
//            while (size-- > 0) {
//                TreeNode x = q.poll();
//                list.add(x.val);
//                if (x.left != null) q.offer(x.left);
//                if (x.right != null) q.offer(x.right);
//            }
//        }

        //note 可以没有最外面一层
        TreeNode x = q.poll();
        list.add(x.val);
        if (x.left != null) q.offer(x.left);
        if (x.right != null) q.offer(x.right);



        //note 发现int不能这样使用，只有String可以
//        return list.toArray(new int[list.size()]);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
