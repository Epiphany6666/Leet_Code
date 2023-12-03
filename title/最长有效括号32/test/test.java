package title.最长有效括号32.test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("()(())"));
    }
}

/*
class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        int[] length = new int[s.length()];
        int k = 0;
        int count = 0;//记录左括号的数
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                count++;
            }
            if (count >= 2){
                ++k;
            }
            if (!stack.isEmpty() && ch == ')') {
                ch = stack.pop();
                count--;
                if (ch == '(') {
                    length[k] += 2;
                }
            }
        }
        Arrays.sort(length);
        return length[length.length - 1];
    }
}*/

/*//法1：动态规划
class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt((i - 1)) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] *//*- 1 *//*> 0 && s.charAt(i - *//*dp[i - dp[i - 1]*//*dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (*//*i - dp[i - dp[i - 1]]*//*(i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}*/

/*
//栈
class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int maxans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}*/

/*
//法1：动态规划
class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxans = 0;
        for (int i = 1; i < s.length(); i++) {//从1开始！！！
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 1 > 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}*/


/*
//法2：栈
class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int maxans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}*/

//法3
class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
//            int count = 0;
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (leftCount == rightCount) {
//                count++;
                maxans = Math.max(maxans, 2 * rightCount);
            } else if (rightCount > leftCount){
                leftCount = rightCount = 0;
            }
//            maxans = Math.max(maxans, count);
        }
        leftCount = rightCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int count = 0;
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (leftCount == rightCount) {
//                count++;
                maxans = Math.max(maxans, 2 * leftCount);
            } else if (leftCount > rightCount){
                leftCount = rightCount = 0;
            }
            maxans = Math.max(maxans, count);
        }
        return maxans;
    }
}