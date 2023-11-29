package title.子数组的最小值之和907.overWrite01;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class test {
}

//method 1：单调栈
class Solution {
    public int sumSubarrayMins(int[] arr) {
        //note 特判
        if (arr == null || arr.length == 0) return 0;

        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new LinkedList<>();

        //记录左边界
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        //记录右边界
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
//            right[i] = stack.isEmpty() ? -1 : stack.peek();
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }

        long ans = 0;
        int MOD = (int)1e9 + 7;
        for (int i = 0; i < len; i++) {
            //note 应该要一起然后再除膜
//            ans += (i - left[i]) * (right[i] - i) * arr[i] % MOD;
            ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int) ans;
    }
}

//method 2：两次遍历，这是因为弹出的i刚好可以作为i的右边界
class Solution2 {
    private static final long MOD = (int) 1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);//方便填充left
        for (int i = 0; i < len; i++) {
            while (stack.size() > 1 && arr[stack.peek()] >= arr[i])
//                right[i] = stack.pop();
                right[stack.pop()] = i;//i正好是栈顶元素的右边界
            left[i] = stack.peek();
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < len; i++) {
            //note 不如最后再取模，但是这里任然要先转为long
//            ans = (ans + (i - left[i]) * (right[i] - i) * arr[i]) % MOD;
            ans += (i - left[i]) * (right[i] - i) * arr[i];
        }
        return (int) (ans % MOD);
    }
}