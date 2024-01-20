package title.IPO502;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class text {
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> list = new ArrayList<>();
        int n = profits.length;
        for (int i = 0; i < n; i++) {
            list.add(new int[] {profits[i], capital[i]});
        }
        Collections.sort(list, (a, b) -> (a[1] - b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int i = 0;
        while (k-- > 0) {
            while (i < n && list.get(i)[1] <= w) pq.offer(list.get(i)[0]);
            if (pq.isEmpty()) break;
            w += pq.poll();
        }
        return w;
    }
}