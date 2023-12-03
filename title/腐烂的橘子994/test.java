package title.腐烂的橘子994;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class test {
}

//mind 第一个想法是并查集，完了，又想逃避了。。。
//mind 但好像又不需要并查集，只需要递归每个坏了的橘子，然后求最小值即可
//method 算了，我的方法刚开始的思路就有问题，，
/*
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int orangesRotting(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                String str = i + "_" + j;

                if (grid[i][j] == 2) dfs(grid, i, j, 0);
            }
        }
    }

    private void dfs(int[][] grid, int i, int j, int minute) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) {
            return;
        }

        if (grid[i][j] == 1) ans = ans

        dfs(grid, i - 1, j, minute + 1);
        dfs(grid, i + 1, j, minute + 1);
        dfs(grid, i, j - 1, minute + 1);
        dfs(grid, i, j + 1, minute + 1);
    }
}*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int cnt = 0;
        Deque<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        //统计新鲜橘子的数量，将腐烂的橘子入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) cnt++;
                else if (grid[i][j] == 2) q.offer(new int[] {i, j});
            }
        }

        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (cnt > 0 && !q.isEmpty()) {
            ans++;
            int size = q.size();
            while (size-- > 0) {
                int[] t = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = t[0] + dir[i][0];
                    int y = t[1] + dir[i][1];
//                    if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        q.offer(new int[] {x, y});
                        //腐烂橘子
                        grid[x][y] = 2;
                        cnt--;
                    }
                }
            }
        }
        if (cnt > 0) {
            return -1;
        } else {
            return ans;
        }
    }
}