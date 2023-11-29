package title.LCR_148_验证图书取出顺序;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

/*
class Solution {
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        if (putIn == null || takeOut == null || putIn.length == 0 || takeOut.length == 0) return true;
        Deque<Integer> stack = new LinkedList<>();
        int idx1 = 0, idx2 = 0;
        while (!stack.isEmpty()) {
            int x = takeOut[idx2++];
            while (stack.peek() != x) {
                if (idx1 == putIn.length) return false;
                stack.offer(putIn[idx1++]);
            }
            stack.pop();
        }
        return true;
    }
}*/

//method 写法是真的牛
class Solution {
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int num : putIn) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == takeOut[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}