package title.设计可以求最短路径的图类2642;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class test {
}

/**
 * 参考题解：灵茶山艾府
 */
// method 1：Dijkstra算法
// mind 这个我记得我写过好几次了，为什么再次碰见还是不会。。。
class Graph1 {
    List<int[]>[] g;
    public Graph1(int n, int[][] edges) {
        g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            addEdge(e);
        }
    }

    public void addEdge(int[] e) {
        g[e[0]].add(new int[] {e[1], e[2]});
    }

    public int shortestPath(int start, int end) {
        int[] dis = new int[g.length];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[] {0, start});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int d = p[0];
            int x = p[1];
            if (x == end) {
                return d;
            }
            if (d > dis[x]) continue;
            for (int[] e : g[x]) {
                int y = e[0];
                int w = e[1];
                if (d + w < dis[y]) {
                    dis[y] = d + w;
                    pq.offer(new int[] {d + w, y});
                }
            }
        }
        return -1;
    }
}


// method 2：floyd算法
class Graph {
    int[][] f;
    public Graph(int n, int[][] edges) {
        f = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
            f[i][i] = 0;
        }
        for (int[] e : edges) {
            f[e[0]][e[1]] = e[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (f[i][k] != Integer.MAX_VALUE && f[k][j] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j]);
                    }
                }
            }
        }
    }

    public void addEdge(int[] e) {
        int x = e[0], y = e[1], w = e[2], n = f.length;
        if (w >= f[x][y]) return;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (f[i][x] != Integer.MAX_VALUE && f[y][j] != Integer.MAX_VALUE) {
                    f[i][j] = Math.min(f[i][j], f[i][x] + f[y][j] + w);
                }
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        int ans = f[node1][node2];
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}