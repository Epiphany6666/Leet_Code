package 周赛.第355场.长度递增组的最大数目6955.合并后数组中的最大元素6915;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        int[] nums = {2,3,7,9,3};
        new Solution().maxArrayValue(nums);
    }
}

/**
 * Deque用都不会用
 * 又在随便乱用。。。。
 * 添加用push，而不是add。。。酸q
 */
class Solution {
    public long maxArrayValue(int[] nums) {
        Stack<Long> stack = new Stack<>();
        int len = nums.length;
        stack.push((long)nums[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            int x = nums[i];
            if (x <= stack.peek()) {
                stack.push(x + stack.pop());
            } else {
                stack.push((long)x);
            }
        }
        long max = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            max = Math.max(max, stack.pop());
        }
        return max;
    }
}