package 周赛.第369场.第3题;


import java.util.Deque;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 0, 2};
        new Solution().minIncrementOperations(nums, 4);
    }
}

/*
class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            while (!q.isEmpty() && nums[i] > q.peekLast()) q.pollLast();
            q.offer(nums[i]);
        }
        int ans = 0;
        int t = q.peek() >= k ? 0 : k - q.peek();
        if (t > 0) {
            ans += t;
            t = q.peek() + 1;
            while (!q.isEmpty() && t > q.peekLast()) q.pollLast();
            q.offer(t);
        }
        for (int i = 3; i < nums.length; i++) {
            while (!q.isEmpty() && nums[i] > q.peekLast()) q.pollLast();
            if (q.peek() == nums[i - 3]) q.poll();
            q.offer(nums[i]);
            t = q.peek() >= k ? 0 : k - q.peek();
            if (t > 0) {
                ans += t;
                t = q.peek() + 1;
                while (!q.isEmpty() && t > q.peekLast()) q.pollLast();
                q.offer(t);
            }
        }
        return ans;
    }
}*/

class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            while (!q.isEmpty() && nums[i] > q.peekLast()) q.pollLast();
            q.offer(nums[i]);
        }
        int ans = 0;
        int t = q.peek() >= k ? 0 : k - q.peek();
        ans += t;
        if (t > 0) {
            t = q.poll() + t;
            q.offerFirst(t);
        }
        for (int i = 3; i < nums.length; i++) {
            while (!q.isEmpty() && nums[i] > q.peekLast()) q.pollLast();
            q.offer(nums[i]);
            t = q.peek() >= k ? 0 : k - q.peek();
            ans += t;
            if (t > 0) {
                t = q.poll() + t;
                q.offerFirst(t);
            }
        }
        return ans;
    }
}
