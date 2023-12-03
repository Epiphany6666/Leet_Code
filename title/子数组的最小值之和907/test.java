package title.子数组的最小值之和907;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

/**
 * 下面给出了两种超时代码，只是为了测试mod操作的占用时间，第一种代码可以过78/87个测试用例，而第二种不用MOD运算的可以过83/87个测试用例，所以得到一个题外话：mod运算真的挺耗时间的。
 */
//method 1：暴力
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int ans = 0, len = arr.length, MOD = (int)1e9 + 7;
        for (int i = 0; i < len; i++) {
            int min = arr[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min, arr[j]);
                ans = (ans + min) % MOD;
            }
        }
        return ans;
    }
}

//method 1：暴力 - 不用MOD，这种方法最好将ans直接定义为long
class Solution2 {
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        int len = arr.length, MOD = (int)1e9 + 7;
        for (int i = 0; i < len; i++) {
            int min = arr[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min, arr[j]);
                ans += min;
                //note 将取余转换为减法
                if (ans >= MOD) ans -= MOD;
            }
        }
        return (int)ans;
    }
}

//method 2：单调栈
class Solution3 {
    public int sumSubarrayMins(int[] arr) {
        //note 特判
        if (arr == null || arr.length == 0) return 0;

        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new LinkedList<>();

        //计算左边界
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        //计算右边界
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }

        //note 下面可能会越界，所以这里最好用long
//        int ans = 0;
        long ans = 0;
        int MOD = (int)1e9 + 7;
        for (int i = 0; i < len; i++) {
//            ans = (ans + arr[i] * (i - left[i]) * (right[i] - i)) % MOD;
            ans = (ans + (long) arr[i] * (i - left[i]) * (right[i] - i)) % MOD;
        }
        return (int)ans;
    }
}