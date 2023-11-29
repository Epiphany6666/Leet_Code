package title.最长公共子序列1143;

public class test {
}

//加上空格
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        String s1 = " " + text1;
        String s2 = " " + text2;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (chars1[i] == chars2[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}