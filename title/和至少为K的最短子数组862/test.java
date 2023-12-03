package title.和至少为K的最短子数组862;
/**
 * 总结
 * 1.双向队列的题第一次做真的做不出，而且跟着代码敲了一遍之后还是有点云里雾里。。。
 * 2.相加一定要考虑要不要将int换成long
 * 3.想不通的多用特例想一下吧，多画图就能想通了，这道题真的是双向队列很典型的一道题。。。
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
}

/**滑动窗口坐半天，结果发现有负数，，，，*/
/*
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int sum = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            if (sum < k) {
                sum += nums[right];
            }
            while (sum >= k){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if (ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }
}*/

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
//        int[] s = new int[n + 1];
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        int ans = n + 1;
        for (int i = 0; i < n + 1; i++) {
            long num = s[i];
            while (!deque.isEmpty() && (num - s[deque.peekFirst()]) >= k) {
                ans = Math.min(ans, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && num <= s[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return ans > n ? -1 : ans;
    }
}