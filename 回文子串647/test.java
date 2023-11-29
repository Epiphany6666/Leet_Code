package title.回文子串647;

public class test {
}

//method 1：动态规划
//mind 天呐，要是没做过这类类型的题我还真想不到。。。
/*class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i) < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}*/

//method 2：中心扩展法
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for (int center = 0; center < 2 * n; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left > ans.length()) ans = s.substring(left, right + 1);
                left--;
                right++;
            }
        }
        return ans;
    }
}