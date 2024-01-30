package title.水壶问题365;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class test {
}

//method 1：DFS --- 迭代
class Solution1 {
    public boolean canMeasureWater(int x, int y, int target) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {0, 0});
        Set<Long> seen = new HashSet<>();
        while (!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));
            int[] state = stack.pop();
            int remain_x = state[0], remain_y = state[1];
            if (remain_x == target || remain_y == target || remain_y + remain_x == target) return true;

            // 把x灌满
            stack.push(new int[] {x, remain_y});
            // 把y灌满
            stack.push(new int[] {remain_x, y});
            // 把x倒空
            stack.push(new int[] {0, remain_y});
            // 把y倒空
            stack.push(new int[] {remain_x, 0});
            // 把x倒到y中去，直至灌满或倒空
            stack.push(new int[] {remain_x - Math.min(remain_x, y - remain_y), remain_y + Math.min(remain_x, y - remain_y)});
            // 把y倒到x中去，直至灌满或倒空
            stack.push(new int[] {remain_x + Math.min(remain_y, x - remain_x), remain_y - Math.min(remain_y, x - remain_x)});
        }
        return false;
    }

    private Long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }
}

//method 2：数学，贝祖定理。。。
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == 0 || y == 0) return z == 0 || x + y == z;
        return z % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}