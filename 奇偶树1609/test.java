package title.奇偶树1609;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(10);
        root.left = t1;
        TreeNode t2 = new TreeNode(4);
        root.right = t2;
        TreeNode t3 = new TreeNode(3);
        t1.left = t3;
        TreeNode t4 = new TreeNode(7);
        t2.left = t4;
        new Solution().isEvenOddTree(root);
    }
}

/**
 * 自写BFS总结：
 * 1.没认真看题，如果题目很绕下次现在纸上打草稿
 * 2.代码太复杂，很多地方都可以优化。
 *   1.题目没要求记录层数，不需要使用具体的数字来记录，而是直接使用flag boolean来标记
 *   2.题目也没说要返回这一排的所有数，此时只需要记录当前数cur和上一个数pre即可
 */
/*
//BFS
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.addLast(root);
        int level = -1;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            int i = -1;
            while (size-- > 0) {
                TreeNode t = queue.pollFirst();
                if (t.left != null) queue.addLast(t.left);
                if (t.right != null) queue.addLast(t.right);
                list.add(t.val);
                i++;
                if (level % 2 == 0 && t.val % 2 == 0) return false;
                if (level % 2 != 0 && t.val % 2 != 0) return false;
                if (i == 0) continue;
                if (level % 2 == 0 && list.get(i) <= list.get(i - 1))
                    return false;
                if (level % 2 != 0 && list.get(i) >= list.get(i - 1))
                    return false;
            }
        }
        return true;
    }
}*/

/*
//BFS优化
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        boolean flag = true;
        while (!d.isEmpty()) {
            int size = d.size(), pre = flag ? 0 : 0x3f3f3f3f;
            while (size-- > 0) {
                TreeNode t = d.pollFirst();
                int cur = t.val;
                if (flag && (pre >= cur || cur % 2 == 0)) return false;
                if (!flag && (pre <= cur || cur % 2 != 0)) return false;
                pre = cur;
                if (t.left != null) d.addLast(t.left);
                if (t.right != null) d.addLast(t.right);
            }
            flag = !flag;
        }
        return true;
    }
}*/


/*
//DSF自写
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        boolean flag = true;
        dfs(root, flag, 0, flag ? 0 : 0x3f3f3f);
    }

    public boolean dfs(TreeNode root, boolean flag, int depth, int pre) {
        if (root.left != null) dfs(root.left, !flag, depth, )
    }
}*/

//DFS想不到，完全想不到。。。，，，
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public boolean isEvenOddTree(TreeNode root) {
        /*if(!dfs(root, 0)) return false;
        return true;*/
        return dfs(root, 0);
    }

    public boolean dfs(TreeNode root, int idx) {
        boolean flag = (idx % 2 == 0);
        int pre = map.getOrDefault(idx, flag ? 0 : 0x3f3f3f3f);
        int cur = root.val;
        map.put(idx, cur);
        if (flag && (cur % 2 != 0 || pre >= cur)) return false;
        if (!flag && (cur % 2 == 0 || pre <= cur)) return false;
        if (root.left != null && !dfs(root.left, idx + 1)) return  false;
        if (root.right != null && !dfs(root.right, idx + 1)) return false;
        return true;
    }
}