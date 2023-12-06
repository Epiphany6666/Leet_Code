package title.重新规划路线1466.overWrite01;

import java.util.*;

public class test {
}

//method 1：DFS
class Solution {
    List<int[]>[] g;
    public int minReorder(int n, int[][] connections) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] connection : connections) {
            int x = connection[0], y = connection[1];
            g[x].add(new int[] {y, 1});
            g[y].add(new int[] {x, 0});
        }

        return dfs(0, -1);
    }

    private int dfs(int cur, int fa) {
        int ans = 0;
        for (int[] x : g[cur]) {
            if (x[0] != fa) {
                ans += x[1] + dfs(x[0], cur);
            }
        }
        return ans;
    }
}

//method 2：BFS
class Solution2 {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());

        for (int[] e : connections) {
            int x = e[0], y = e[1];
            g[x].add(new int[] {y, 1});
            g[y].add(new int[] {x, 0});
        }

        Deque<Integer> q = new ArrayDeque<>();
        //note 不小心携程他得包装类了，半天没看出来。。
//        Boolean[] visited = new Boolean[n];
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            int cur = q.pop();
            for (int[] x : g[cur]) {
                if (!visited[x[0]]) {
                    ans += x[1];
                    q.offer(x[0]);
                    visited[x[0]] = true;
                }
            }
        }
        return ans;
    }
}