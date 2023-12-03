package title.打开转盘锁752;

import java.util.*;

public class test {
    public static void main(String[] args) {
        new Solution().openLock(new String[] {"8888"}, "0009");
    }
}

//method 双向优先遍历
//node 题目要求一次只能转一个数字！！！！
/*
class Solution {
    Set<String> visited = new HashSet<>();
    Deque<String> beginDeque = new ArrayDeque<>();
    Deque<String> endDeque = new ArrayDeque<>();
    public int openLock(String[] deadends, String target) {
        String begin = "0000";
        visited.addAll(Arrays.asList(deadends));
        visited.addAll(Arrays.asList(begin, target));
        beginDeque.offer(begin);
        endDeque.offer(target);

        int step = 1;
        while (!beginDeque.isEmpty() && !endDeque.isEmpty()) {
            if (beginDeque.size() > endDeque.size()) {
                Deque<String> tmp;
                tmp = beginDeque;
                beginDeque = endDeque;
                endDeque = tmp;
            }

            int size = beginDeque.size();
            while (size-- > 0) {
                String cur = beginDeque.poll();
                if (isTarget(cur, target)) {
                    return step + 1;
                }
            }
            step++;
        }
        return -1;
    }

    private boolean isTarget(String cur, String target) {
        char[] charArray = cur.toCharArray();
        for (int i = 0; i < 4; i++) {
            char tmp = charArray[i];
            for (char n = '0'; n <= '9'; n++) {
                if (tmp == n) continue;
                charArray[i] = n;
                String newCur = String.valueOf(charArray);
                if (endDeque.contains(newCur)) {
                    return true;
                }
                if (!visited.contains(newCur)) {
                    beginDeque.offer(newCur);
                    visited.add(newCur);
                }
            }
            //恢复
            charArray[i] = tmp;
        }
        return false;
    }
}*/

class Solution {
    Set<String> visited = new HashSet<>();
    Deque<String> beginDeque = new ArrayDeque<>();
    Deque<String> endDeque = new ArrayDeque<>();
    public int openLock(String[] deadends, String target) {
        //mind 好贱，这题，漏了两种情况：1.target就是“0000” 2.target或者“0000”就在deadends里面。。。
        String begin = "0000";
        //1.
        if (begin.equals(target)) return 0;
        visited.addAll(Arrays.asList(deadends));
        //2.
        if (visited.contains(target) || visited.contains(begin)) return 0;
        visited.addAll(Arrays.asList(begin, target));
        beginDeque.offer(begin);
        endDeque.offer(target);

        //note 区分单词接龙，这里是从0开始
//        int step = 1;
        int step = 0;
        while (!beginDeque.isEmpty() && !endDeque.isEmpty()) {
            if (beginDeque.size() > endDeque.size()) {
                Deque<String> tmp;
                tmp = beginDeque;
                beginDeque = endDeque;
                endDeque = tmp;
            }

            int size = beginDeque.size();
            while (size-- > 0) {
                String cur = beginDeque.poll();
                if (isTarget(cur, target)) {
                    return step + 1;
                }
            }
            step++;
        }
        return -1;
    }

    private boolean isTarget(String cur, String target) {
        char[] charArray = cur.toCharArray();
        for (int i = 0; i < 4; i++) {
            char tmp = charArray[i];
//            for (char n = '0'; n <= '9'; n++) {
            for (int j = -1; j <= 1; j++) {
                int t = tmp + j;
//                char n = (char)(t + j);
                char n = (char)t;
                if (t == 47) n = '9';
                if (t == 58) n = '0';
                if (tmp == n) continue;
                charArray[i] = n;
                String newCur = String.valueOf(charArray);
                if (endDeque.contains(newCur)) {
                    return true;
                }
                if (!visited.contains(newCur)) {
                    beginDeque.offer(newCur);
                    visited.add(newCur);
                }
            }
            //恢复
            charArray[i] = tmp;
        }
        return false;
    }
}