package title.LCR_152_验证二叉搜索树的后序遍历序列;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

//method 1：递归
/*
class Solution {
    public boolean verifyTreeOrder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int l, int r) {
        if (l >= r) return true;
        int p = l;
        while (postorder[p] < postorder[r]) p++;
        int m = p;
        while (postorder[p] > postorder[r]) p++;
//        return p == r && recur(postorder, l, m - 1) && recur(postorder, m, r);
        return p == r && recur(postorder, l, m - 1) && recur(postorder, m, r - 1);
    }
}*/

//method 2：栈
class Solution {
    public boolean verifyTreeOrder(int[] postorder) {
        Deque<Integer> stack = new LinkedList<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && postorder[i] < stack.peek()) root = stack.pop();
            stack.push(postorder[i]);
        }
        return true;
    }
}