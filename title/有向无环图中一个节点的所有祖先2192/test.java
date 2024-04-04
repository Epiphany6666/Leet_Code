package title.有向无环图中一个节点的所有祖先2192;

import java.util.*;

public class test {
}

/**
 * 参考题解：力扣官方题解
 */
// method 拓扑排序
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] deg = new int[n];
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            deg[y]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.offer(i);
            }
        }
        Set<Integer>[] anc = new Set[n];
        Arrays.setAll(anc, e -> new HashSet<>());
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Integer v : g[u]) {
                anc[v].add(u);
                for (Integer i : anc[u]) {
                    anc[v].add(i);
                }
                if (--deg[v] == 0) {
                    q.offer(v);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < anc.length; i++) {
            ans.add(new ArrayList<>());
            for (Integer j : anc[i]) {
                ans.get(i).add(j);
            }
            Collections.sort(ans.get(i));
        }
        return ans;
    }
}