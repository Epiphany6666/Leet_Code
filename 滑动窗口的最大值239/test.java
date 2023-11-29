package title.滑动窗口的最大值239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class test {
}

/*
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans;
        int idx = 0;
        if (len <= k) {
            ans = new int[1];
            ans[idx] = Arrays.stream(nums).max().getAsInt();
            return ans;
        }
        ans = new int[len - 3 + 1];

    }
}*/

//method 双向队列。。。
/*
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (nums == null || len < 2) return nums;

        int[] ans = new int[len - k + 1];
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.addLast(i);
            if (q.peek() <= i - k) {
                q.poll();
            }

            if (i + 1 >= k) {
                ans[i + 1 - k] = nums[q.peek()];
            }
        }
        return ans;
    }
}*/

//method 2：直接用数字入队
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (nums == null || len < 2) return nums;
        int[] ans = new int[len - k + 1];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0, j = 1 - k; i < len; i++, j++) {
            if (j > 0 && q.peek() == nums[j - 1]) {
                q.pollFirst();
            }
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.pollLast();
            }
            q.addLast(nums[i]);
            if (j >= 0) {
                ans[j] = q.peekFirst();
            }
        }
        return ans;
    }
}