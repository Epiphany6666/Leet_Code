package title.最长回文子串5;

public class test {
}

/*
//method 1：动态规划
class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > ans.length()) ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}*/

