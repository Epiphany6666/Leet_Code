package Leet_Code.src.title.清除数字3174;

import java.util.Stack;

public class test {
}

class Solution1 {
    public String clearDigits(String s) {
        Stack<Character> cs = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!cs.empty() && Character.isDigit(c)) {
                cs.pop();
            } else {
                cs.push(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Character c : cs) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}

// method ：灵神
class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}