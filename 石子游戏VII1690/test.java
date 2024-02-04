package 石子游戏VII1690;

public class test {
}

/**
 * 参考灵神题解
 */
// method 1：递归（超时）
class Solution1 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = stones[i] + s[i];
        }
        return dfs(0, n - 1, s);
    }

    private int dfs(int i, int j, int[] s) {
        if (i == j) return 0;
        return Math.max(s[j + 1] - s[i + 1] - dfs(i + 1, j, s), s[j] - s[i] - dfs(i, j - 1, s));
    }
}

// method 2：记忆化
class Solution2 {
    Integer[][] memo;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        memo = new Integer[n][n];
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = stones[i] + s[i];
        }
        return dfs(0, n - 1, s);
    }

    private int dfs(int i, int j, int[] s) {
        if (i == j) return 0;
        if (memo[i][j] != null) return memo[i][j];
        memo[i][j] = Math.max(s[j + 1] - s[i + 1] - dfs(i + 1, j, s), s[j] - s[i] - dfs(i, j - 1, s));
        return memo[i][j];
    }
}

// method 3：动态规划
class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = stones[i] + s[i];
        }
        int[][] f = new int[n][n];
        for (int i = n - 2; i >= 0; i++) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = Math.max(s[j + 1] - s[i + 1] - f[i + 1][j], s[j] - s[i] - f[i][j - 1]);
            }
        }
        return f[0][n - 1];
    }
}