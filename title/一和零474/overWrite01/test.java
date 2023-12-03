package title.一和零474.overWrite01;

public class test {
}

/*
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return dfs(strs, 0, m, n);
    }

    public int dfs(String[] strs, int depth, int m, int n) {
        if (depth >= strs.length) return 0;
        int count1 = count(strs[depth]);
        int count0 = strs[depth].length() - count1;
        int right = 0;
        if (!(m - count0 < 0 || n - count1 < 0))
            right = dfs(strs, depth + 1, m - count0, n - count1) + 1;
        int left = dfs(strs, depth + 1, m, n);
        return Math.max(left, right);
    }

    public int count(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') res++;//太粗心了，这里应该是字符'1'
        }
        return res;
    }
}*/


//法2：动态规划
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int[] cnt = countZeroAndOne(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zeros = cnt[0];
                    int ones = cnt[1];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int[] countZeroAndOne(String s) {
        int[] cnt = new int[2];
        for (char c : s.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }
}