package title.不同路径62;

import java.util.Arrays;

public class test {
}

/*
//mind 算了，想不出，还是看答案吧。。
class Solution {
    public int uniquePaths(int m, int n) {
        //dp定义：到达i，j点一共有dp[i][j]条路径
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ()
            }
        }
    }
}*/

//method 1：排列组合

//method 2：动态规划

class Solution1 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //question 第一行和第一列全都初始化为1？
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            //note i居然写成了1、。。。
            dp[0][i] = 1;
//            dp[0][1] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}


//method 空间复杂度优化1：
/*
class Solution {
    public int uniquePaths(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
//                cur[i] = cur[i - 1] + pre[j];
                cur[j] = cur[j - 1] + pre[j];
            }
            pre = cur.clone();
        }
        return cur[n - 1];
    }
}*/

//method 空间复杂度优化2：
class Solution {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}