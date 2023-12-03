package title.二叉搜索树中第K小的元素230;

import java.util.*;

public class test {
}

/**
 * 二叉搜索树来说是不允许有重复的值出现的
 */
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k - 1);
    }

    //中序遍历！mind 昨天才写过，你别今天又只会递归方法了
    //method 1：递归
    */
/*private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
        *//*


    //method 2：迭代
    */
/*private void dfs(TreeNode root, List<Integer> list) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                list.add(temp.val);
                root = temp.right;
            }
        }
    }*//*



    //method 3：莫里斯遍历
    private void dfs(TreeNode root, List<Integer> list) {
        TreeNode pre = null;
        while (root != null) {
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                TreeNode temp = root;
                root = root.left;
                temp.left = null;
            } else {
                list.add(root.val);
                root = root.right;
            }
        }
    }
}*/

////method 中序遍历其实不需要遍历完整棵树，也不用借助到list
//class Solution {
//    int ans = 0, k;
//    public int kthSmallest(TreeNode root, int k) {
//        //这里注意，ans和k最好不要定义在里面，因为普通变量它会跟着递归回溯的，但是我们并不需要回溯！
////        int ans = 0;
//        dfs(root, k, ans);
//        return ans;
//    }
//
//    //method 1：递归
//    private void dfs(TreeNode root, int k, int ans) {
//        if (root == null) return;
//        dfs(root.left, k, ans);
//        if (--k == 0) ans = root.val;
//        dfs(root.right, k, ans);
//    }
//
//    //method 2：迭代
////    private void dfs(TreeNode root, List<Integer> list) {
////        Deque<TreeNode> stack = new ArrayDeque<>();
////
////        while (!stack.isEmpty() || root != null) {
////            if (root != null) {
////                stack.push(root);
////                root = root.left;
////            } else {
////                TreeNode temp = stack.pop();
////                list.add(temp.val);
////                root = temp.right;
////            }
////        }
////    }
//
//
//    //method 3：莫里斯遍历
////    private void dfs(TreeNode root, List<Integer> list) {
////        TreeNode pre = null;
////        while (root != null) {
////            if (root.left != null) {
////                pre = root.left;
////                while (pre.right != null) {
////                    pre = pre.right;
////                }
////                pre.right = root;
////                TreeNode temp = root;
////                root = root.left;
////                temp.left = null;
////            } else {
////                list.add(root.val);
////                root = root.right;
////            }
////        }
////    }
//}

//method 2：统计结点个数
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        MyBst myBst = new MyBst(root);
        return myBst.kthSmallest(k);
    }
}

class MyBst {
    Map<TreeNode, Integer> nodeCnt;
    TreeNode root;
    public MyBst(TreeNode root) {
        nodeCnt = new HashMap<>();
        this.root = root;
        countNodeNum(root);
    }

    public int countNodeNum(TreeNode root) {
        if (root == null) return 0;
        nodeCnt.put(root, countNodeNum(root.left) + countNodeNum(root.right) + 1);
        return nodeCnt.get(root);
    }

    //question 为什么这样超时啊，，，
    //因为nodeCnt计算的是左子树加右子树的个数！！！！
    /*public int kthSmallest(int k) {
//        int cnt = nodeCnt.get(root);
        //method 这里可以不用使用ans遍历
//        int ans = 0;
//        TreeNode temp = new TreeNode();
        TreeNode temp = root;
        while (temp != null)
        {
            int cnt = nodeCnt.getOrDefault(temp, 0);
            if (cnt < k) {
                k -= cnt;
                temp = temp.right;
            } else if (cnt > k) {
                k--;
                temp = temp.left;
            } else {
//                ans = temp.val;
                break;
            }
        }
//        return ans;
        return temp.val;
    }*/

    //mind 这里只能计算左子树的个数！
    public int kthSmallest(int k) {
//        int cnt = nodeCnt.get(root);
        //method 这里可以不用使用ans遍历
//        int ans = 0;
//        TreeNode temp = new TreeNode();
        TreeNode temp = root;
        while (temp != null)
        {
            int cnt = nodeCnt.getOrDefault(temp.left, 0);
            if (cnt < k - 1) {
                k -= cnt + 1;
                temp = temp.right;
            } else if (cnt > k - 1) {
                temp = temp.left;
            } else {
//                ans = temp.val;
                break;
            }
        }
//        return ans;
        return temp.val;
    }
}