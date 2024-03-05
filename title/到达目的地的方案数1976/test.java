package title.到达目的地的方案数1976;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class test {
}

class Solution {
    public int countPaths(int n, int[][] roads) {
//        int mod = (int)10e9 + 7;
        int mod = (int)1e9 + 7;
        List<int[]>[] g = new List[n];
//        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : roads) {
            int x = e[0], y = e[1], t = e[2];
            g[x].add(new int[] {y, t});
            g[y].add(new int[] {x, t});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;
        pq.offer(new long[] {0, 0});
        int[] ways = new int[n];
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] arr = pq.poll();
            long t = arr[0];
            int u = (int) arr[1];
            if (t > dis[u]) {
                continue;
            }
            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                if (t + w < dis[v]) {
                    dis[v] = t + w;
                    ways[v] = ways[u];
                    pq.offer(new long[] {t + w, v});
                } else if (t + w == dis[v]) {
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}