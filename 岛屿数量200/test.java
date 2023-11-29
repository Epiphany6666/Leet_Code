package title.岛屿数量200;

public class test {
}

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans= 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, m, n, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int m, int n, int i, int j) {
//        if (i < 0 && i >= m && j < 0 && j >= n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        //////////////
        if (grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';
        dfs(grid, m, n, i - 1, j);
        dfs(grid, m, n, i, j - 1);
        dfs(grid, m, n, i, j + 1);
        dfs(grid, m, n, i + 1, j);
    }
}