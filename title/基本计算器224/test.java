package title.基本计算器224;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
    public static void main(String[] args) {
        new Solution().calculate("1-(     -2)");
    }
}

class Solution1 {
    public int calculate(String s) {
//        去掉所有空格
        s = s.replace(" ", "");
        Deque<Integer> nums = new ArrayDeque<>();
//        为了防止第一个数为负数
        nums.push(0);
        Deque<Character> ops = new ArrayDeque<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peekFirst() != '(') calc(nums, ops);
                ops.pop();
            } else {
                if (isNumber(c)) {
                    int u = 0;
                    int j = i;
                    while (j < n && isNumber(cs[j])) u = u * 10 + cs[j++] - '0';
                    i = j - 1;
                    nums.push(u);
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.add(0);
                    } else {
                        while (!ops.isEmpty() && ops.peekFirst() != '(') calc(nums, ops);
                        ops.add(c);
                    }
                }
            }
        }
        while (!ops.isEmpty()) calc(nums, ops);
        return nums.peekFirst();
    }

    private boolean isNumber(char c) {
        return Character.isDigit(c);
    }

    private void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pop(), a = nums.pop();
        char op = ops.pop();
        nums.push(op == '+' ? a + b : a - b);
    }
}

class Solution {
    public int calculate(String s) {
//        去掉所有空格
        s = s.replace(" ", "");
        Deque<Integer> nums = new ArrayDeque<>();
//        为了防止第一个数为负数
        nums.push(0);
        Deque<Character> ops = new ArrayDeque<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    char op = ops.peekFirst();
                    if (op != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pop();
                        break;
                    }
                }
            } else {
                if (isNumber(c)) {
                    int u = 0;
                    int j = i;
                    while (j < n && isNumber(cs[j])) u = u * 10 + cs[j++] - '0';
                    i = j - 1;
                    nums.push(u);
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.push(0);
                    }
//                    这里不能有else
                    while (!ops.isEmpty() && ops.peekFirst() != '(') calc(nums, ops);
                    ops.push(c);
                }
            }
        }
        while (!ops.isEmpty()) calc(nums, ops);
        return nums.peekFirst();
    }

    private boolean isNumber(char c) {
        return Character.isDigit(c);
    }

    private void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pop(), a = nums.pop();
        char op = ops.pop();
        nums.push(op == '+' ? a + b : a - b);
    }
}