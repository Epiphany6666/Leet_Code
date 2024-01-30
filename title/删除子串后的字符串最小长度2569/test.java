package title.删除子串后的字符串最小长度2569;

import java.util.ArrayDeque;

public class test {
    public static void main(String[] args) {
//        new Solution().minLength("ABFCACDB");
    }
}

// error 第一次删除之后剩下的字符串可能还包含这两个
class Solution1 {
    public int minLength(String s) {
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && ((s.charAt(i) == 'A' && s.charAt(i + 1) == 'B') || (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D'))) {
                i++;
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.length();
    }
}

//method 1：暴力
class Solution2 {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "").replace("CD", "");
        }
        return s.length();
    }
}

//method 2：栈
class Solution {
    public int minLength(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && ((c == 'B' && stack.peek() == 'A') || (c == 'D' && stack.peek() == 'C')))
                stack.pop();
            else stack.push(c);
        }
        return stack.size();
    }
}