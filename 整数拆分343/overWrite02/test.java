package title.整数拆分343.overWrite01;

public class test {
}

//method 1：动态规划
/*class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j])];
            }
        }
        return dp[n];
    }
}*/

class Solution {
    public int integerBreak(int n) {
        if (n < 3) {
            return n * (n - 1);
        }
        int a = n / 3, b = n % 3;
        if (b == 2) return (int)Math.pow(3, a) * b;
        else if (b == 1) return (int)Math.pow(3, a - 1) * 4;
        else return (int)Math.pow(3, a);
    }
}