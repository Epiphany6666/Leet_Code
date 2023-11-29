package title.柱状图中最大的矩形84;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 队列的顶部在队首
 * Deque：
 * peek等价于peekFirst
 *
 * 在Deque中，add()和offer()方法都用于在队列的尾部插入元素。它们的区别在于当队列已满时的处理方式：
 * add()方法在队列已满时会抛出IllegalStateException异常。
 * offer()方法在队列已满时会返回false。
 *
 * 就把Deque看做队列来看就行了，只不过当成栈的时候，它是从左往右推的，因为栈是后进先出，所以后面进的应该在队首
 */

/**
 * public static native void arraycopy(Object src,  int  srcPos,
 *                                         Object dest, int destPos,
 *                                         int length);
 * 将数组从指定的源阵列（从指定位置开始）复制到目标阵列的指定位置。
 */

public class test {
}

//method 1：暴力，两个变量，固定其中一个变量不动，这里肯定固定高不动
//mind 我连暴力都做不出。。。
/*
class Solution {
    public int largestRectangleArea(int[] heights) {
        int bottom = 1;
        int ans = 0;
        int height = 0;
        for (int h : heights) {
            if (h > height) {
                bottom = 1;
                height
            }
        }
    }
}*/

//暴力超时
/*
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int left = i;
            //找出左边最后一个大于等于height[i]的下标
            while (left > 0 && heights[left - 1] >= heights[i]) left--;

            int right = i;
            //找出右边最后一个大于等于height[i]的下标
            while (right < len - 1 && heights[right + 1] >= heights[i]) right++;
            ans = Math.max(ans, (right - left + 1) * heights[i]);
        }
        return ans;
    }
}*/

//method 2：栈
//note 以下代码的peekLast都需要改成peekFirst
/*
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            //note Stack里面存储的是下标！
//            while (!stack.isEmpty() && heights[i] < stack.peekLast()) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
//                int curHeight = stack.pop();
                int curHeight = heights[stack.pop()];

                while (!stack.isEmpty() && curHeight == heights[stack.peekLast()]) {
                    stack.pop();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                ans = Math.max(ans, curHeight * curWidth);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
//            int curHeight = stack.pop();
            int curHeight = heights[stack.pop()];

            while (!stack.isEmpty() && curHeight == heights[stack.peekLast()]) {
                stack.pop();
            }

            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            ans = Math.max(ans, curHeight * curWidth);
        }
        return ans;
    }
}*/

//method 栈优化 - 加哨兵
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length + 2;
        int[] tmp = new int[len];
        System.arraycopy(heights, 0, tmp, 1, len - 2);
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;

        //note 为什么heights忘记换成了tmp？
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekFirst()]) {
                int curHeight = heights[stack.pop()];
                ans = Math.max(ans, curHeight * (i - stack.peekFirst() - 1));
            }
            stack.push(i);
        }
        return ans;
    }
}