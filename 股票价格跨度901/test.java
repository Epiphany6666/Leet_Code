package title.股票价格跨度901;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
}

//method 1：单调栈
/*
class StockSpanner {
    Deque<int[]> q;
    int cur = 0;
    public StockSpanner() {
        q = new ArrayDeque<>();
    }

    public int next(int price) {
        while (!q.isEmpty() && q.peekLast()[1] <= price) q.pollLast();
        int pre = q.isEmpty() ? -1 : q.peekLast()[0];
        int ans = cur - pre;
        q.addLast(new int[] {cur++, price});
        return ans;
    }
}*/


//method 2：数组+指针
class StockSpanner {
    int idx = 0;
    int[] prices, days;
    public StockSpanner() {
        prices = new int[(int)1e4 + 1];
        days = new int[(int)1e4 + 1];
        idx = 0;
    }

    public int next(int price) {
        int p = idx - 1;
        while (p >= 0 && prices[p] <= price) p -= days[p];
        prices[idx] = price;
        days[idx] = idx - p;
        return days[idx++];
    }
}