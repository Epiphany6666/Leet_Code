package title.字符串解码394;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
    public static void main(String[] args) {
        new Solution().decodeString("2[abc]3[cd]ef");
    }
}

/*
//method 自己写了一点最后还是决定看题解，果然，写错了。。
class Solution {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cnt = 0;
            while (c >= '1' && c <= '9') {
                cnt = cnt * 10 + (c - '0');
                continue;
            }
            //需要入栈
            if (c == '[') {
                StringBuilder sb = new StringBuilder();
                while (s.charAt(i) != ']') {
                    sb.append(c);
                    i++;
                }
            }
        }
    }
}*/

/*
//method 1：辅助栈法
class Solution {
    public String decodeString(String s) {
        Deque<Integer> stack_multi = new ArrayDeque<>();
        Deque<String> stack_ans = new ArrayDeque<>();
        //note 这个用法真的值得学习
        int multi = 0;
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack_ans.push(ans.toString());
                ans = new StringBuilder();
                stack_multi.push(multi);
                multi = 0;
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int k = stack_multi.poll();
                for (int i = 0; i < k; i++) temp.append(ans);
                ans = new StringBuilder(stack_ans.poll() + temp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}*/

//method 2：递归
class Solution {
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int k) {
        int multi = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = k; i < s.length(); ) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else if (c == '[') {
                String[] temp = dfs(s, i + 1);
                i = Integer.parseInt(temp[0]);
                //note 这里犯大忌了。。。如果multi--放在循环上，会多执行一次，导致变成了-1 ！
//                while (multi-- > 0) {
                while (multi > 0) {
                    ans.append(temp[1]);
                    multi--;
                }
            } else if (c == ']') {
                return new String[] {String.valueOf(i), ans.toString()};
            } else {
                ans.append(c);
            }
            i++;
        }
        return new String[] {ans.toString()};
    }
}