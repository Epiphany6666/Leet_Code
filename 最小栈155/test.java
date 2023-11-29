package title.最小栈155;

import java.util.*;

public class test {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(0);
        obj.push(1);
        obj.push(0);
        obj.pop();
        int top = obj.top();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}

/**
 * 1.利用Deque模拟栈，它是从左向右入栈的，所以后入栈的在最左边，所用方法应该为：stack.peekFirst()
 * 2.TreeMap默认排序规则:按照key的字典顺序来排序(升序)。
 * 3.Deque中peek()等价于peekFirst()
 */
/*
//method 1：自写
class MinStack {
    //note set是不能重复的，这里面包含重复元素！
    //TreeSet获取最顶端元素就是：first方法
//    TreeSet<Integer> t;
    TreeMap<Integer, Integer> t;
    Deque<Integer> stack;
    public MinStack() {
        t = new TreeMap<>();
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        t.put(val, t.getOrDefault(val, 0) + 1);
    }

    public void pop() {
        int ans = stack.pop();
        t.put(ans, t.get(ans) - 1);
        if (t.get(ans) == 0) t.remove(ans);
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return t.firstKey();
    }
}*/

//method 2：辅助栈
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> stack_min;
    public MinStack() {
        stack = new ArrayDeque<>();
        stack_min = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (stack_min.isEmpty()) stack_min.push(val);
        else stack_min.push(Math.min(stack_min.peekFirst(), val));//note 法2：就是让stack_min先入栈一个最大值
    }

    public void pop() {
        stack.pop();
        stack_min.pop();
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return stack_min.peekFirst();
    }
}