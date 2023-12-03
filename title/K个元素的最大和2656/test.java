package title.K个元素的最大和2656;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class test {
}

//单调栈。。。我自己写的是什么鬼东西
/*class Solution {
    Deque<Integer> q = new LinkedList<>();
    public void add(int num) {
        //note 问题出在这，应该移除最后一个元素
//        while (!q.isEmpty() && q.peekLast() <= num) q.pop();
        while (!q.isEmpty() && q.peekLast() <= num) q.removeLast();
        q.offerLast(num);
    }

    public int maximizeSum(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) {
            add(num);
        }

        for (int i = 0; i < k; i++) {
            int x = q.pop();
            ans += x;
            add(x + 1);
        }
        return ans;
    }
}*/

//method 根本用不到单调队列啊
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        return (2 * max + k - 1) * k / 2;
    }
}