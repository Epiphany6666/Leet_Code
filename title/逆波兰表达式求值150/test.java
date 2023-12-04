package title.逆波兰表达式求值150;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class test {
}

/**
 * 注意["18"]测试用例
 */
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Deque<String> stack = new ArrayDeque<>();
        Set<String> set = new HashSet<>(){{
            add("+");
            add("-");
            add("*");
            add("/");
        }};

        int ret = Integer.parseInt(tokens[0]);
        for (String token : tokens) {
            if (!set.contains(token)) {//为数字
                stack.push(token);
            } else {//为运算符
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        ret = a + b;
                        break;
                    case "-":
                        ret = a - b;
                        break;
                    case "*":
                        ret = a * b;
                        break;
                    case "/":
                        ret = a / b;
                        break;
                    default:
                        break;
                }
                stack.push(ret + "");
            }
        }
        return ret;
    }
}

//method 简化
class Solution2 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int b = stack.pop(), a = stack.pop();
                int ret = 0;
                switch (token) {
                    case "+":
                        ret = a + b;
                        break;
                    case "-":
                        ret = a - b;
                        break;
                    case "*":
                        ret = a * b;
                        break;
                    case "/":
                        ret = a / b;
                        break;
                    default:
                        break;
                }
                stack.push(ret);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

//method 2：用数组模拟堆栈
class Solution3 {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int idx = -1;
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int b = stack[idx--], a = stack[idx--];
                switch (token) {
                    case "+":
                        stack[++idx] = a + b;
                        break;
                    case "-":
                        stack[++idx] = a - b;
                        break;
                    case "*":
                        stack[++idx] = a * b;
                        break;
                    case "/":
                        stack[++idx] = a / b;
                        break;
                    default:
                        break;
                }
            } else {
                stack[++idx] = Integer.parseInt(token);
            }
        }
        return stack[idx];
    }
}