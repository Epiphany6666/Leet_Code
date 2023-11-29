package title.统计无向图中无法相互到达点对数2316;

import java.util.*;

public class test {
}

/*
//method 1：并查集
class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
//        int ans = 0;
        long ans = 0;
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        for (int i = 0; i < n; i++) {
            ans += (n - unionFind.getSize(i));
        }
        return ans / 2;
    }
    private class UnionFind {
        int[] parent;
        int[] size;
        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public int getSize(int n) {
            int rootN = find(n);
            return size[rootN];
        }
    }
}*/

//method 2：BFS
/*
class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e ->new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        boolean[] visited = new boolean[n];
        long ans = 0;
//        for (int i = 0, total = 0; i < n; i++) {
//            int size = 1;
//            if (!visited[i]) {
//                size = dfs(g, i, visited);
//            }
//            ans += (long)size * total;
//        }
        for (int i = 0, total = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(g, i, visited);
                ans += (long)size * total;
                total += size;
            }
        }
        return ans;
    }
    private int dfs(List<Integer>[] g, int x, boolean[] visited) {
        visited[x] = true;
        int size = 1;
        for (Integer y : g[x]) {
            if (!visited[y]) {
                size += dfs(g, y, visited);
            }
        }
        return size;
    }
}*/


//method 3：BFS
class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> q = new LinkedList<>();
//        q.add(0);

        long ans = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                q.offer(i);
                int count = 1;
                while (!q.isEmpty()) {
                    int x = q.poll();
                    for (Integer y : g[x]) {
                        if (!visited[y]) {
                            visited[y] = true;
                            count++;
                            q.offer(y);
                        }
                    }
                }
                ans += (long) count * total;
            }
        }
        return ans / 2;
    }
}