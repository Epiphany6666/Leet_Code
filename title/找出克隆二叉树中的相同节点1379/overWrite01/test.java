package title.找出克隆二叉树中的相同节点1379.overWrite01;

public class test {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


// method 自写
class Solution1 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        return getTargetCopy(original.left, cloned.left, target) == null ? getTargetCopy(original.right, cloned.right, target) : getTargetCopy(original.left, cloned.left, target);
    }
}

/**
 * 参考题解：灵茶山艾府
 */
// 代码优化
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) return left;
        return getTargetCopy(original.right, cloned.right, target);
    }
}