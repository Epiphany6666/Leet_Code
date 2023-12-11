package title.最小体力消耗路径1631;

import java.util.*;

public class test {
    public static void main(String[] args) {

    }
}

//method 1：二分查找
class Solution2 {
    public int minimumEffortPath(int[][] heights) {
        int l = 0, r = (int)1e6 - 1;
        int ans = 0;
        int m = heights.length, n = heights[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //note 这里必须是等号
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            Deque<int[]> q = new ArrayDeque<>();
            q.offer(new int[] {0, 0});
            boolean[] visited = new boolean[m * n];
            while (!q.isEmpty()) {
                int[] cell = q.poll();
                for (int[] dir : dirs) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    visited[x * n + y] = true;
                    if (!(x >= 0 && x < m && y >= 0 && y < n) && !visited[x * n + y] && Math.abs(heights[x][y] - heights[cell[0]][cell[1]]) <= mid) {
                        q.offer(new int[] {x, y});
                    }
                }
            }

            if (visited[m * n - 1]) {
                ans = mid;
                r = mid - 1;
            } else {
                r = mid + 1;
            }
        }
        return ans;
    }
}

//method 2：并查集（Kruskal）
class Solution3 {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        UnionFind unionFind = new UnionFind(m * n);
        int ans = 0;
        //建图
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i * n + j;
                if (i + 1 < m) {
                    int y = (i + 1) * n + j;
                    edges.add(new int[] {x, y, Math.abs(heights[i][j] - heights[i + 1][j])});
                }
                if (j + 1 < n) {
                    int y = i * n + j + 1;
                    edges.add(new int[] {x, y, Math.abs(heights[i][j] - heights[i][j + 1])});
                }
            }
        }
        Collections.sort(edges, (a, b) -> (a[2] - b[2]));
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            //note 这里不是求最小生成树，这里可以生成环，也可以不生成环，对答案都没有影响
//            if (unionFind.isConnected(x, y)) continue;
//            ans += edge[2];
            unionFind.union(x, y);
            if (unionFind.isConnected(0,  m * n - 1)) {
                //note 答案就是最后一条，差距最大的边
                ans = edge[2];
                break;
            }
        }
        return ans;
    }

}

class UnionFind {
    int[] parent;
    int[] size;
    int cnt;

    public UnionFind(int n) {
        parent = new int[n];
        //mind 太粗心了，忘记给size初始化了
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        cnt = n;
    }

    public int find(int x) {
//        while (x != parent[x]) {
//            parent[x] = parent[parent[x]];
//            //note 少了这一句话，导致了死循环
//            x = parent[x];
//        }
//        return parent[x];

        //note 路径压缩写法2：
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    public void union (int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;

//        if (size[x] < size[y]) {
//            int tmp = size[x];
//            size[x] = size[y];
//            size[y] = tmp;
//        }

        //note 总是搞混
//        if (size[x] < size[y]) {
//            int tmp = x;
//            x = y;
//            y = tmp;
//        }
//        parent[y] = rootX;

        if (size[rootX] < size[rootY]) {
            int tmp = rootX;
            rootX = rootY;
            rootY = tmp;
        }
        parent[rootY] = rootX;

//        size[rootY] += size[rootX];
        size[rootX] += size[rootY];
        cnt--;
    }

    public int getCnt() {
        return cnt;
    }

    public boolean isConnected(int x, int y) {
//        return parent[x] == parent[y];
        return find(x) == find(y);
    }
}

//method 3：Dijkstra算法
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> (i[2] - j[2]));
        pq.offer(new int[] {0, 0, 0});
        int[] disk = new int[m * n];
        //note 最重要的填充居然忘记了
        Arrays.fill(disk, Integer.MAX_VALUE);
        //note 初始位置需要置为0
        disk[0] = 0;
        boolean[] visited = new boolean[m * n];
        //note 0还不能被标记！
//        visited[0] = true;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int x = edge[0], y = edge[1], w = edge[2];
            if (visited[x * n + y]) continue;
            if (x == m - 1 && y == n - 1) break;
            //note 应该在这里标记
            visited[x * n + y] = true;
            for (int[] dir : dirs) {
                int xn = x + dir[0];
                int yn = y + dir[1];
                //ntoe 太粗心了。。。
//                if (x >= 0 && x < m && y >= 0 && y < n && !visited[xn * m + yn] && Math.max(w, Math.abs(heights[x][y] - heights[xn][yn])) < disk[xn * m + y]) {
                if (xn >= 0 && xn < m && yn >= 0 && yn < n && Math.max(w, Math.abs(heights[x][y] - heights[xn][yn])) < disk[xn * n + yn]) {
                    disk[xn * n + yn] = Math.max(w, Math.abs(heights[x][y] - heights[xn][yn]));
                    pq.offer(new int[] {xn, yn, disk[xn * n + yn]});
                }
            }
        }
        return disk[m * n - 1];
    }
}