package title.最大正方形221;

public class test {
}

class Solution1 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxSize = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j], dp[i][j + 1]), dp[i + 1][j]) + 1;
                    maxSize = Math.max(maxSize, dp[i + 1][j + 1]);
                }
            }
        }
        return maxSize * maxSize;
    }
}

// method 空间优化
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n + 1];
        int maxSize = 0;
        for (char[] chars : matrix) {
            int northwest = 0;
            for (int i = 0; i < n; i++) {
                int nextNorthwest = dp[i + 1];
                if (chars[i] == '1') {
                    dp[i + 1] = Math.min(Math.min(dp[i], dp[i + 1]), northwest) + 1;
                    maxSize = Math.max(maxSize, dp[i + 1]);
                } else {
                    dp[i + 1] = 0;
                }
                northwest = nextNorthwest;
            }
        }
        return maxSize * maxSize;
    }
}