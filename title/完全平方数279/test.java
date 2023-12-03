package title.完全平方数279;

public class test {
    public static void main(String[] args) {
        new Solution().numSquares(12);
    }
}

/*
class Solution {
    public int numSquares(int n) {
        int ans = 0;
        int x = n;
        while (x > 0) {
            if (isSquares(x)) {
                ans += n / x;
                x = n % x;
                n = x;
            }
            //mind 又忘记
            x--;
        }
        return ans;
    }

    private boolean isSquares(int x) {
        return x == (int)Math.sqrt(x) * (int)Math.sqrt(x);
    }
}*/

//动态规划。。。动态规划。。。动态规划。。。
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;//全是1的情况
            for (int j = 0; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}