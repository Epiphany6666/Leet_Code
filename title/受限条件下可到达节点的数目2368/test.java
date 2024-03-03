package title.受限条件下可到达节点的数目2368;

import java.util.*;

public class test {
}

/**
 * 参考题解：灵茶山艾府
 */
//method 1：DFS - 解法1
class Solution1 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] isRestricted = new boolean[n];
        for (int i : restricted) {
            isRestricted[i] = true;
        }
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            if (!isRestricted[x] && !isRestricted[y]) {
                g[x].add(y);
                g[y].add(x);
            }
        }
        return dfs(0, -1, g);
    }

    private int dfs(int x, int fa, List<Integer>[] g) {
        int cnt = 1;
        for (Integer y : g[x]) {
            if (y != fa) {
                cnt += dfs(y, x, g);
            }
        }
        return cnt;
    }
}

/**
 * 参考题解：ylb
 */
//method 2：DFS - 解法2
class Solution2 {
    boolean[] vis;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        vis = new boolean[n];
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
//        boolean[] isRestricted = new boolean[n];
//        for (int x : restricted) {
//            isRestricted[x] = true;
//        }
        for (int i : restricted) {
            vis[i] = true;
        }
        for (int[] e : edges) {
            int x = e[0], y = e[1];
//            if (!isRestricted[x] && !isRestricted[y]) {
                g[x].add(y);
                g[y].add(x);
//            }
        }
        return dfs(0, g);
    }

    private int dfs(int x, List<Integer>[] g) {
//        if (vis[x]) return 0;
        vis[x] = true;
        int cnt = 1;
        for (Integer y : g[x]) {
            if (!vis[y]) {
                cnt += dfs(y, g);
            }
        }
        return cnt;
    }
}

//method 3：BFS
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] vis = new boolean[n];
//        boolean[] isRestricted = new boolean[n];
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i : restricted) {
            vis[i] = true;
        }
        for (int[] e : edges) {
            int x = e[0], y = e[1];
//            if (!isRestricted[x] && !isRestricted[y]) {
                g[x].add(y);
                g[y].add(x);
//            }
        }
        int ans = 1;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (Integer y : g[x]) {
                if (!vis[y]) {
                    q.offer(y);
//                    ans++;
                    vis[y] = true;
                }
            }
            ans++;
        }
        return ans;
    }
}