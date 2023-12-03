package title.最近的请求次数933;

import java.util.Deque;
import java.util.LinkedList;

public class test {
}

/*
class RecentCounter {
    int[] pre;
    int p = 0;
    public RecentCounter() {
        pre = new int[(int)1e9];
    }

    public int ping(int t) {
        for (int i = p + 1; i < t; i++) {
            pre[i] = pre[p];
        }
        pre[t] = pre[t - 1] + 1;
        p = t;
        return pre[t] - pre[t - 3000];
    }
}*/

//method 1：队列
class RecentCounter {
    Deque<Integer> q = new LinkedList<>();
    public int ping(int t) {
        q.offer(t);
        while (q.peek() < t - 3000) q.poll();
        return q.size();
    }
}