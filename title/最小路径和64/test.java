package title.最小路径和64;

public class test {
}

//method dfs超时。。。
/*
class Solution {
    int ans = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        //note 题目说了，只能向下或向右移动！
        //mind 但还是超时。。。
//        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dir = {{1, 0}, {0, 1}};
        dfs(grid, 0, 0, 0, dir);
        return ans;
    }

    private void dfs(int[][] grid, int i, int j, int sum, int[][] dir) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) {
            return;
        }

        if (grid[i][j] == -1) return;
        sum += grid[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            ans = Math.min(ans, sum);
            return;
        }
        int t = grid[i][j];
        grid[i][j] = -1;
        for (int k = 0; k < 4; k++) {
            dfs(grid, i + dir[k][0], j + dir[k][1], sum, dir);
        }
        grid[i][j] = t;
    }
}*/

//method 典型的动态规划题。。。。
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //note 直接在原数组上改即可
//        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
            }
        }
//        return dp[m - 1][n - 1];
        return grid[m - 1][n - 1];
    }
}