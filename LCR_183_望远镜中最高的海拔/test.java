package title.LCR_183_望远镜中最高的海拔;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class test {
}

/*
class Solution {
    public int[] maxAltitude(int[] heights, int limit) {
        int len = heights.length;
        if (len == 0) return new int[0];
        if (len < limit) return new int[] {Arrays.stream(heights).max().getAsInt()};
        int[] ans= new int[len - limit + 1];
        //note 不写等于的话，就会少一个数
//        for (int i = limit; i < len; i++) {
        for (int i = limit; i <= len; i++) {
            ans[i - limit] = Arrays.stream(Arrays.copyOfRange(heights, i - limit, i)).max().getAsInt();
        }
        return ans;
    }
}*/

//method 2：单调栈
//mind 我的写法太杂太乱了，一点也不好理解
/*class Solution {
    public int[] maxAltitude(int[] heights, int limit) {
        int len = heights.length;
        if (len == 0 || limit == 0) return new int[0];
        Deque<Integer> q = new LinkedList<>();
        int[] ans = new int[len - limit + 1];
        for (int i = 0; i < len; i++) {
            //note i = limit - 1 的时候是窗口刚好形成的时候
//            if (i >= limit - 1 && q.peek() == heights[i - limit + 1]) q.poll();
            if (i >= limit && q.peek() == heights[i - limit]) q.poll();
            while (!q.isEmpty() && q.peekLast() < heights[i]) {
                q.pollLast();
            }
            q.offer(heights[i]);
            if (i >= limit - 1) ans[i - limit + 1] = q.peek();
        }
        return ans;
    }
}*/

//method 大佬的写法
/*class Solution {
    public int[] maxAltitude(int[] heights, int limit) {
        int len = heights.length;
        if (len == 0 || limit == 0) return new int[0];
        Deque<Integer> q = new LinkedList<>();
        int[] ans = new int[len - limit + 1];
        for (int j = 0, i = 1 - limit; j < len; i++, j++) {
            if (i > 0 && q.peek() == heights[i - 1]) q.poll();
//            while (!q.isEmpty() && q.peekLast() < heights[j]) q.poll();
            while (!q.isEmpty() && q.peekLast() < heights[j]) q.pollLast();
            q.offer(heights[j]);
            if (i >= 0) ans[i] = q.peek();
        }
        return ans;
    }
}*/

//method 先形成窗口
class Solution {
    public int[] maxAltitude(int[] heights, int limit) {
        int len = heights.length;
        if (len == 0 || limit == 0) return new int[0];
        Deque<Integer> q = new LinkedList<>();
        int[] ans = new int[len - limit + 1];
        for (int i = 0; i < limit; i++) {
            while (!q.isEmpty() && q.peekLast() < heights[i]) q.pollLast();
            q.offer(heights[i]);
        }
        ans[0] = q.peek();
        for (int i = limit; i < len; i++) {
            if (q.peek() == heights[i - limit]) q.poll();
            while (!q.isEmpty() && q.peekLast() < heights[i]) q.pollLast();
            q.offer(heights[i]);
            ans[i - limit + 1] = q.peek();
        }
        return ans;
    }
}