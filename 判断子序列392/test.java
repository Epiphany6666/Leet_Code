package title.判断子序列392;

public class test {
}

//method 双指针
//mind 复杂题目做多了，简单的字符串题目反而不会做了。。。
//note 以后写程序还是要多考虑特判的情况
/*class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS > lenT) return false;
        int ps = 0;
        //note 特判ps是否已经提前完成了
//        for (int i = 0; i < lenT; i++) {
        for (int i = 0; i < lenT && ps < lenS; i++) {
            if (s.charAt(ps) == s.charAt(i)) ps++;
        }
        if (ps == lenS) return true;
        return false;
    }
}*/

/*
class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS > lenT) return false;
        //note lenS为0的情况
        if (lenS == 0) return true;
        int ps = 0;
        for (int i = 0; i < lenT; i++) {
            if (s.charAt(ps) == s.charAt(i)) ps++;
            if (ps == lenS) return true;
        }
        return false;
    }
}*/

//method 2：动态规划。。。
/*
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[n + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[n][i] = n;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        int add = 0;
        for (int i = 0; i < m; i++) {
            if (dp[add][s.charAt(i) - 'a'] == n) return false;
//            add = dp[add][s.charAt(i) - 'a'];
            add = dp[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}*/

//重写
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[n + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[n][i] = n;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        int add = 0;
        for (int i = 0; i < m; i++) {
            if (dp[add][s.charAt(i) - 'a'] == n) return false;
//            add = dp[add][s.charAt(i) - 'a'];
            add = dp[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}