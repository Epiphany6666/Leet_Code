package 周赛.第357场.故障键盘6925.overWrite01;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
}

// method 自写
class Solution01 {
    public String finalString(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            // note reverse()是直接反转sb本身，而不是返回
//            if (c == 'i') sb = sb.reverse();
            if (c == 'i') sb.reverse();
            else sb.append(c);
        }
        return sb.toString();
    }
}

/**
 * 参考：灵茶山艾府
 */
// method 双端队列
class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        boolean tail = true;
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                tail = !tail;
            } else if (tail) {
                deque.addLast(c);
            } else if (!tail) {
                deque.addFirst(c);
            }
        }
        for (Character c : deque) {
            sb.append(c);
        }
        if (!tail) sb.reverse();
        return sb.toString();
    }
}