package title.检查骑士巡视方案2596;

public class test {
}

//写的太丑陋了
/*
class Solution {
    public boolean checkValidGrid(int[][] grid) {
        Boolean[][] ans = new Boolean[grid.length][grid.length];
        dfs(grid, ans, 0, 0, 0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (!ans[i][j])
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] grid, boolean[][] ans, int i, int j, int depth) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length) {
            return false;
        }
        if (grid[i][j] == depth) {
            ans[i][j] = true;
        }
    }
}*/

//mind 这个方法真的很巧妙！
class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;

        int n = grid.length;
        int[][] index = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                index[grid[i][j]][0] = i;
                index[grid[i][j]][1] = j;
            }
        }

        for (int i = 1; i < n * n; i++) {
            /*int x = index[i][0] - index[i - 1][0];
            int y = index[i][1] - index[i - 1][1];*/
            int x = Math.abs(index[i][0] - index[i - 1][0]);
            int y = Math.abs(index[i][1] - index[i - 1][1]);
            if (x * y != 2) {
                return false;
            }
        }
        return true;
    }
}