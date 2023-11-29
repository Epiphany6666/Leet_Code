package title.美化数组的最小删除数2216;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 双向队列中peek()等价于peekFirst()!!!
 */
public class test {
}

class Solution {
    public int minDeletion(int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int num : nums) {
            if (dq.isEmpty()) {
                dq.offer(num);
                continue;
            }
            if (dq.size() % 2 == 1 && num == dq.peek()) continue;
            dq.offer(num);
        }
        return dq.size() % 2 == 0 ? nums.length - dq.size() :nums.length - dq.size() + 1;
    }
}