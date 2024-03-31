package title.验证二叉树的前序序列化331;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class test {
}

/**
 * 参考题解：负雪明烛，由于它没有Java题解，所以又去参考了大佬ylb的题解！
 * 这种写法利用了前序遍历的 “「前序遍历」是按照「根节点-左子树-右子树」的顺序遍历的” 的特点
 */
// method 1：栈
class Solution1 {
    public boolean isValidSerialization(String preorder) {
        List<String> stack = new ArrayList<>();
        String[] cs = preorder.split(",");
        for (String c : cs) {
            stack.add(c);
            while (stack.size() >= 3 && stack.get(stack.size() - 1).equals("#") && stack.get(stack.size() - 2).equals("#") && !stack.get(stack.size() - 3).equals("#")) {
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.add("#");
            }
        }
        return stack.size() == 1 && stack.get(0).equals("#");
    }
}

// method 2：计算入度出度
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] ss = preorder.split(",");
        int diff = 1;
        for (String s : ss) {
            diff -= 1;
            if (diff < 0) return false;
            if (!s.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}