package title.验证二叉搜索树98;


import java.util.Deque;
import java.util.LinkedList;

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

/*
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        //note 不是结点是否相同相比较啊。。。
        if (root.left != root.right) return false;
        return isValidBST(root.left) || isValidBST(root.right);
    }
}*/

//改写，还是错了。。。
/*
class Solution {
    public boolean isValidBST(TreeNode root) {
    //  note 原因出在root如果为根结点，root.left == null直接返回true了
        if (root == null || root.left == null || root.right == null) return true;
        if (root.left.val > root.right.val) return false;
        return isValidBST(root.left) || isValidBST(root.right);
    }
}*/

//继续改
//note 还是错了，这是因为不是左边的结点比根结点小就行了，还需要左边的一整颗树的结点都比根结点小！
/*
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if ((root.left != null && root.right != null && root.left.val >= root.right.val) || (root.left != null && root.val <= root.left.val) || (root.right != null && root.val >= root.right.val)) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
}*/

//mind 算了，还是去看题解吧。。
//method 1：递归
/*class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int lower, int upper) {
        if (root == null) return true;
        int val = root.val;
        if (val <= lower || val >= upper) return false;
        return isValidBST(root.left, lower, val) && isValidBST(root.right, val, upper);
    }
}*/

//note [2147483647]这个测试用例是真的变态，，，
/*
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        int val = root.val;
        if (val <= lower || val >= upper) return false;
        return isValidBST(root.left, lower, val) && isValidBST(root.right, val, upper);
    }
}*/

//method 2：栈
//mind 怎么写着写着又变成递归了。。。
/*class Solution {
    Deque<TreeNode> stack = new LinkedList<>();
    Deque<Long> lowers = new LinkedList<>();
    Deque<Long> uppers = new LinkedList<>();
    public boolean isValidBST(TreeNode root) {
        long lower = Long.MIN_VALUE, upper = Long.MAX_VALUE, val;
        update(root, lower, upper);
        if (root == null) return true;
        val = root.val;
        if (val <= lower || val >= upper) return false;
        update(root.left, lower, val);
        update(root.right, val, upper);
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private void update(TreeNode root, long lower, long upper) {
        stack.push(root);
        lowers.push(lower);
        uppers.push(upper);
    }
}*/

//改1
/*class Solution {
    Deque<TreeNode> stack = new LinkedList<>();
    Deque<Long> lowers = new LinkedList<>();
    Deque<Long> uppers = new LinkedList<>();
    public boolean isValidBST(TreeNode root) {
        long lower = Long.MIN_VALUE, upper = Long.MAX_VALUE, val;
        update(root, lower, upper);
        if (root == null) return true;

        while (!stack.isEmpty()) {
        //   note 这里没有考虑val为空的情况！
            val = stack.pop().val;
            lower = lowers.pop();
            upper = uppers.pop();
            if (val <= lower || val >= upper) return false;
            update(root.left, lower, val);
            update(root.right, val, upper);
        }
        return true;
    }

    private void update(TreeNode root, long lower, long upper) {
        stack.push(root);
        lowers.push(lower);
        uppers.push(upper);
    }
}*/

//改2
/*class Solution {
    Deque<TreeNode> stack = new LinkedList<>();
    Deque<Long> lowers = new LinkedList<>();
    Deque<Long> uppers = new LinkedList<>();
    public boolean isValidBST(TreeNode root) {
        long lower = Long.MIN_VALUE, upper = Long.MAX_VALUE, val;
        update(root, lower, upper);
        if (root == null) return true;

        while (!stack.isEmpty()) {
            root = stack.pop();
            lower = lowers.pop();
            upper = uppers.pop();
            if (root == null) continue;
            val = root.val;
            if (val <= lower || val >= upper) return false;
            update(root.left, lower, val);
            update(root.right, val, upper);
        }
        return true;
    }

    private void update(TreeNode root, long lower, long upper) {
        stack.push(root);
        lowers.push(lower);
        uppers.push(upper);
    }
}*/

//method 3：中序遍历 - 递归
/*//mind 这个你应该擅长啊，前几天才写过的
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
//        boolean left = isValidBST(root.left);
//        boolean right = isValidBST(root.right);

        //修改：
        //mind 大佬的代码自动很简洁。。。
        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}*/

//method 3：中序遍历 - 迭代
/*
class Solution {
    public boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left != null) stack.push(temp.left);
            if (temp.right != null) stack.push(temp.right);
        }
    }
}*/

//mind 无语，居然忘光光了。。
/*class Solution {
    public boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val <= pre) return false;
                pre = root.val;
                root = root.right;
            }
        }
        return true;
    }
}*/

//method 3：中序遍历 - 莫里斯遍历
class Solution {
    public boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE;
        while (root != null) {
            if (root.left != null) {
                TreeNode p = root.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = root;
                TreeNode t = root;
                root = root.left;
                t.left = null;
            } else {
                if (root.val <= pre) return false;
                pre = root.val;
                root = root.right;
            }
        }
        return true;
    }
}