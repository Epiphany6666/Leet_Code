package title.分割回文串131;

import java.util.*;

public class test {
}

/**
 * public String(char value[], int offset, int count) {
 * 分配一个新的字符串，其中包含字符数组参数的子数组中的字符。offset 参数是子数组第一个字符的索引，count 参数指定子数组的长度。
 */

/*
class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return ans;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                string(s.substring(i, j + 1));
            }
        }
        return ans;
    }

    public void string(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        List<String> list = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    list.add(s.substring(i, j + 1));
                }
            }
        }
        if (list.size() != 0) ans.add(list);
    }
}*/


/*
//method 1：使用动态规划
class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
        //note
//            for (int i = 0; i < j; i++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        Deque<String> q = new ArrayDeque<>();
        dfs(s, q, 0, dp);
        return ans;
    }

    private void dfs(String s, Deque<String> q, int depth, boolean[][] dp) {
        if (depth == s.length()) {
            ans.add(new ArrayList<>(q));
        }

        for (int i = depth; i < s.length(); i++) {
            if (dp[depth][i]) {
                q.add(s.substring(depth, i + 1));
                dfs(s, q, i + 1, dp);
                q.removeLast();
            }
        }
    }
}*/

//method 2
class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return ans;
        Deque<String> q = new ArrayDeque<>();
        //note 它这里使用了一个技巧，截取字符串是会消耗性能的，所以它这里使用了转为数组
        char[] charArray = s.toCharArray();
        dfs(charArray, q, 0);
        return ans;
    }

    private void dfs(char[] charArrays, Deque<String> q, int depth) {
        if (depth == charArrays.length) {
            ans.add(new ArrayList<>(q));
        }
        for (int i = depth; i < charArrays.length; i++) {
            if (checkPalindrome(charArrays, depth, i)) {
                //note 将字符数组转化为字符串，不带逗号的！
                q.addLast(new String(charArrays, depth, i + 1 - depth));
                dfs(charArrays, q, i + 1);
                q.removeLast();
            }
        }
    }

    private boolean checkPalindrome(char[] charArrays, int l, int r) {
        while (l < r) {
            if (charArrays[l] != charArrays[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}