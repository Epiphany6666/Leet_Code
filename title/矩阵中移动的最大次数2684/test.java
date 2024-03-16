package title.矩阵中移动的最大次数2684;

import java.util.*;

public class test {
}

/**
 * 自写
 */
// method 1：递归：超时
class Solution01 {
    // note 审题：你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid
//    public int maxMoves(int[][] grid) {
//        return dfs(grid, 0, 0);
//    }
    // note 审题：第一列。。。
//    public int maxMoves(int[][] grid) {
//        int max = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                max = Math.max(max, dfs(grid, i, j));
//            }
//        }
//        return max;
//    }
    public int maxMoves(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            // mind 额、、、行列位置写反。。。
//            max = Math.max(max, dfs(grid, 0, i));
            max = Math.max(max, dfs(grid, i, 0));
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        // note：审题 三个单元格中任一满足值 严格 大于当前单元格的单元格。
//        int a = dfs(grid, i - 1, j + 1);
//        int b = dfs(grid, i, j + 1);
//        int c = dfs(grid, i + 1, j + 1);
        int a = 0, b = 0, c = 0;
        if (i - 1 >= 0 && i - 1 < grid.length && j + 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] > grid[i][j]) {
            a = dfs(grid, i - 1, j + 1);
        }
        if (i >= 0 && i < grid.length && j + 1 >= 0 && j + 1 < grid[0].length && grid[i][j + 1] > grid[i][j]) {
            b = dfs(grid, i, j + 1);
        }
        if (i + 1 >= 0 && i + 1 < grid.length && j + 1 >= 0 && j + 1 < grid[0].length && grid[i + 1][j + 1] > grid[i][j]) {
            c = dfs(grid, i + 1, j + 1);
        }
        return 1 + Math.max(a, Math.max(b, c));
    }
}

// method 2：记忆化搜索
class Solution02 {
    private int ans = 0;
    Map<String, Integer> map = new HashMap<>();
    public int maxMoves(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            max = Math.max(max, dfs(grid, i, 0));
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        String key = i + "_" + j;
        if (map.containsKey(key)) return map.get(key);
        int a = 0, b = 0, c = 0;
        if (i - 1 >= 0 && i - 1 < grid.length && j + 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] > grid[i][j]) {
            a = dfs(grid, i - 1, j + 1);
        }
        if (i >= 0 && i < grid.length && j + 1 >= 0 && j + 1 < grid[0].length && grid[i][j + 1] > grid[i][j]) {
            b = dfs(grid, i, j + 1);
        }
        if (i + 1 >= 0 && i + 1 < grid.length && j + 1 >= 0 && j + 1 < grid[0].length && grid[i + 1][j + 1] > grid[i][j]) {
            c = dfs(grid, i + 1, j + 1);
        }
        map.put(key, 1 + Math.max(a, Math.max(b, c)));
        return map.get(key);
    }
}

/**
 * 参考题解：灵神
 */
// method 1：网格图DFS
class Solution1 {
    int ans = 0;
    public int maxMoves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(i, 0, grid);
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] grid) {
        ans = Math.max(ans, j);
        if (ans == grid[0].length - 1) return; // ans已经达到最大值
        for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, grid[0].length); k++) {
            if (grid[k][j + 1] > grid[i][j]) {
                dfs(k, j + 1, grid);
            }
        }
        // 将grid[i][j]置为0，标记为访问过
        grid[i][j] = 0;
    }
}

//method 2：网格BFS
class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] vis = new int[m];
        Arrays.fill(vis, -1);

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            q.offer(i);
        }
        for (int j = 0; j < n - 1; j++) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();
                for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, m); k++) {
                    if (vis[k] != j && grid[k][j + 1] > grid[i][j]) {
                        vis[k] = j;
                        q.offer(k);
                    }
                }
                if (q.isEmpty()) {
                    return j;
                }
            }
        }
        return n - 1;
    }
}