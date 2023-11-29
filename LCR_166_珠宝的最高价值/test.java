package title.LCR_166_珠宝的最高价值;

public class test {
}

/*
class Solution {
    public int jewelleryValue(int[][] frame) {
        if (frame.length == 0) return 0;
        int m = frame.length, n = frame[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = frame[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (j - 1 > 0) dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + frame[i][j]);
                if (i - 1 > 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + frame[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}*/

//method 2：直接在原数组上修改
/*
class Solution {
    public int jewelleryValue(int[][] frame) {
        int m = frame.length;
        int n = frame[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) frame[i][j] += frame[i][j - 1];
                else if (j == 0) frame[i][j] += frame[i - 1][j];
                else frame[i][j] += Math.max(frame[i][j - 1], frame[i - 1][j]);
            }
        }
        return frame[m - 1][n - 1];
    }
}*/

//method 3：先特判
/*
class Solution {
    public int jewelleryValue(int[][] frame) {
        int m = frame.length, n = frame[0].length;
        for (int i = 1; i < n; i++) {
            frame[0][i] += frame[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            frame[i][0] += frame[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                frame[i][j] += Math.max(frame[i][j - 1], frame[i - 1][j]);
            }
        }
        return frame[m - 1][n - 1];
    }
}*/

//method 4：多开一行一列
class Solution {
    public int jewelleryValue(int[][] frame) {
        int m = frame.length, n = frame[0].length;
        //note dp[i][j]表示的是从frame[0][0]到dp[i - 1][j - 1]的最大值
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + frame[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}