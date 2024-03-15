package title.卖木头块2312;

public class test {
}

/**
 * 参考题解：灵神
 */
class Solution1 {
    public long sellingWood(int m, int n, int[][] prices) {
        int[][] p = new int[m + 1][n + 1];
        for (int[] pr : prices) {
            p[pr[0]][pr[1]] = pr[2];
        }
//        int[][] f = new int[m + 1][n + 1];
        long[][] f = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = p[i][j];
//                for (int k = 1; k < i; k++) f[i][j] = Math.max(f[i][j], Math.max(f[i][k], f[i][j - k]));
//                for (int k = 1; k < j; k++) f[i][j] = Math.max(f[i][j], Math.max(f[k][j], f[i - k][j]));
                for (int k = 1; k < j; k++) f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]);
                for (int k = 1; k < i; k++) f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]);
            }
        }
        return f[m][n];
    }
}

// method ：优化
class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        int[][] pr = new int[m + 1][n + 1];
        for (int[] p : prices) {
            pr[p[0]][p[1]] = p[2];
        }
        long[][] f = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = pr[i][j];
                for (int k = 1; k <= j / 2; k++) f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]);
                for (int k = 1; k <= i / 2; k++) f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]);
            }
        }
        return f[m][n];
    }
}