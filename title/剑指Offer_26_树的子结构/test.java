package title.剑指Offer_26_树的子结构;

/**
 *总结：
 * 1 居然把PriorityQueue的poll和offer与Deque中的记混了。。。
 * 2 Deque中（这一队用来模仿队列）
 *      poll()等价于pollFirst()
 *      offer()等价于 offerLast()
 * 3 常用push This method is equivalent to addFirst.
 *   和
 *   pop This method is equivalent to removeFirst().
 *   来模仿栈
 */

public class test {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
/**
 * 层次遍历做不到，而且不行！
 */
/*class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        String str1 = levelTrack(A);
        String str2 = levelTrack(A);
        return str1.contains(str2);
    }

    private String levelTrack(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Deque<TreeNode> dq = new ArrayDeque<>();

        if (root != null) dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                TreeNode node = dq.poll();
                sb.append(node.val);
                if (node.left != null) dq.offer(node.left);
                else
                if (node.right != null) dq.offer(node.right);
            }
        }
        return sb.toString();
    }
}*/

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;
        return recur(a.left, b.left) && recur(a.right, b.right);
    }
}