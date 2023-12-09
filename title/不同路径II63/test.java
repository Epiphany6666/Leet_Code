package title.不同路径II63;

import java.util.Arrays;

public class test {
}

//method 1：DFS 超时
class Solution {
    int m, n, ans;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dfs(0, 0, obstacleGrid);
        return ans;
    }

    //note 测试用例：[[0,0],[0,1]]
//    private void dfs(int x, int y, int[][] obstacleGrid) {
//        if (x == m - 1 && y == n - 1) {
//            ans++;
//            return;
//        }
//        if (obstacleGrid[x][y] == 1) return;
//        if (!(x >= 0 && x < m && y >= 0 && y < n)) return;
//
//        dfs(x + 1, y, obstacleGrid);
//        dfs(x, y + 1, obstacleGrid);
//    }

        private void dfs(int x, int y, int[][] obstacleGrid) {
        //note 这个顺序必须在第一个
        if (!(x >= 0 && x < m && y >= 0 && y < n)) return;
        //note 这个顺序必须在第二个
        if (obstacleGrid[x][y] == 1) return;
        if (x == m - 1 && y == n - 1) {
            ans++;
            return;
        }

        dfs(x + 1, y, obstacleGrid);
        dfs(x, y + 1, obstacleGrid);
    }
}

//method 2：记忆化
class Solution2 {
    int m, n;
    int[][] mem;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(mem[i], -1);
        }
        int ans = dfs(0, 0, obstacleGrid);
        return ans;
    }

    private int dfs(int x, int y, int[][] obstacleGrid) {
        if (!(x >= 0 && x < m && y >= 0 && y < n)) return 0;

        if (mem[x][y] != -1) return mem[x][y];

        if (obstacleGrid[x][y] == 1) return 0;
        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        int ans = 0;
        ans += dfs(x + 1, y, obstacleGrid);
        ans += dfs(x, y + 1, obstacleGrid);

        mem[x][y] = ans;
        return ans;
    }
}

//method 3：动态规划
class Solution3 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        //note 从1, 1开始
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == 1) continue;
//                if (i - 1 >= 0) dp[i][j] += dp[i - 1][j];
//                if (j - 1 >= 0) dp[i][j] += dp[i][j - 1];
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

//method 4：动态规划 - 滚动数组
class Solution4 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                if (i - 1 >= 0) dp[i] = dp[i] + dp[i - 1];
            }
        }
        return dp[m - 1];
    }
}

class Solution5 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        //note 注意遍历顺序
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][j] == 1) {
                    //note 还有这里注意归0
                    dp[i] = 0;
                    continue;
                }
                if (i - 1 >= 0) dp[i] = dp[i] + dp[i - 1];
            }
        }
        return dp[m - 1];
    }
}

class Solution6 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {dp[j] = 0; continue;}
                if (j - 1 >= 0) dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}