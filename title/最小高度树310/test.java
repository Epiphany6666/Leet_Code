package title.最小高度树310;

import java.util.*;

public class test {
}

/**
 * 自写
 */
// method 超时
class Solution0 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int depth = dfs(i, -1,  g, edges);
            List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
            list.add(i);
            map.put(depth, list);
            min = Math.min(min, depth);
        }
        return map.get(min);
    }

    private int dfs(int cur, int fa, List<Integer>[] g, int[][] edges) {
        int max = 0;
        for (Integer x : g[cur]) {
            if (x != fa) {
                max = Math.max(max, dfs(x, cur, g, edges));
            }
        }
        return max + 1;
    }
}

/**
 * 参考题解：liweiwei1419
 * 拓扑排序
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n < 2) {
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
            return ans;
        }

        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] deg = new int[n];
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
            deg[x]++;
            deg[y]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) q.offer(i);
        }

        while (n > 2) {
            int size = q.size();
            n -= size;
            while (size-- > 0) {
                int x = q.poll();
                for (Integer i : g[x]) {
                    deg[i]--;
                    if (deg[i] == 1) q.offer(i);
                }
            }
        }
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        return ans;
    }
}