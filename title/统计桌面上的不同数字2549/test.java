package title.统计桌面上的不同数字2549;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class test {
}

//class Solution {
//    public int distinctIntegers(int n) {
//        Set<Integer> set = new HashSet<>();
//        set.add(n);
//        Deque<Integer> q = new ArrayDeque<>();
//        for (int i = 1; i < n; i++) {
//            q.offer(i);
//        }
//    }
//}

/**
 * 参考题解：Storm
 */
// method 1：模拟
class Solution1 {
    public int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        boolean flag = true;
        while (flag) {
            flag = false;
            Set<Integer> prev = new HashSet<>(set);
            for (Integer x : prev) {
                for (int i = 1; i <= n; i++) {
                    if (x % i == 1 && set.add(i)) {
                        flag = true;
                    }
                }
            }
        }
        return set.size();
    }
}

/**
 * 参考题解：灵茶山艾府
 */
// method 2；数学
class Solution {
    public int distinctIntegers(int n) {
        return Math.max(n - 1, 1);
    }
}
