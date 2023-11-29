package title.找出克隆二叉树中的相同节点1379;

import java.util.ArrayDeque;
import java.util.Deque;

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
    TreeNode ans = null;
    public final TreeNode getTargetCopy(final TreeNode original,
    final TreeNode cloned, final TreeNode target) {
        dfs(cloned, target.val);
        return ans;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            ans = root;
            return;
        }

        dfs(root.left, val);
        dfs(root.right, val);
    }
}*/

//method 1：前序遍历 - 递归
/*class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
//        TreeNode left = getTargetCopy(original.left, cloned.left, target);
//        TreeNode right = getTargetCopy(original.right, cloned.right, target);
//
//        if (left != null) {
//            return left;
//        } else if (right != null) {
//            return right;
//        } else {
//            return null;
//        }

        //note 可以递归一个就判断一个
        TreeNode ans = getTargetCopy(original.left, cloned.left, target);
        if (ans != null) {
            return ans;
        }

        ans = getTargetCopy(original.right, cloned.right, target);
        if (ans != null) {
            return ans;
        }
        return null;
    }
}*/

//method 2：前序遍历 - 非递归
//mind 为什么每次接触自己不擅长的领域的时候都想着逃避，你不去写，你怎么提高？？？
/*
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> cloneStack = new ArrayDeque<>();
        TreeNode node = original;
        TreeNode cloneNode = cloned;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                //若左节点不空，则访问左子树
                if (node == target) {
                    return cloneNode;
                }

                stack.push(node);
                node = node.left;
                cloneStack.push(cloneNode);
                cloneNode = cloneNode.left;
            } else {
                //结点空了，访问右子树
                node = stack.pop().right;
                cloneNode = cloneStack.pop().right;
            }
        }
        return null;
    }
}*/

//method 3：层次遍历
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        Deque<TreeNode> dqClone = new ArrayDeque<>();
        TreeNode node = original;
        TreeNode nodeClone = cloned;
        dq.offer(node);
        dqClone.offer(nodeClone);
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                node = dq.poll();
                nodeClone = dqClone.poll();
                if (node == target) {
                    return nodeClone;
                }
                /*if (node.left != null) dq.offer(node.left);
                if (node.right != null) dq.offer(node.right);
                if (nodeClone.left != null) dqClone.offer(nodeClone.left);
                if (nodeClone.right != null) dqClone.offer(nodeClone.right);*/
                //node 简写
                if (node.left != null) {
                    dq.offer(node.left);
                    dqClone.offer(nodeClone.left);
                }
                if (node.right != null) {
                    dq.offer(node.right);
                    dqClone.offer(nodeClone.right);
                }
            }
        }
        return null;
    }
}