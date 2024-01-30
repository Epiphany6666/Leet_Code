package title.自由之路514;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
}

// 错误太多
class Solution1 {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        List<Integer>[] pos = new List[26];
        Arrays.fill(pos, new ArrayList<>());
        for (int i = 0; i < m; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for (Integer i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, m - i) + 1;
        }
        for (int i = 1; i < m; i++) {
            for (Integer j : pos[key.charAt(i) - 'a']) {
                for (Integer k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(k - j), m - (k - j))) + 1;
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}

class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        List<Integer>[] pos = new List[26];
//        Arrays.fill(pos, new ArrayList<>());
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for (Integer i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, m - i) + 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), m - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }
}