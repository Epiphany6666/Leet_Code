package title.LCR_131_砍竹子I.overWrite01;

public class test {
}

//method 1：动态规划
/*
class Solution {
    public int cuttingBamboo(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}*/

//method 2：数学
class Solution {
    public int cuttingBamboo(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int)Math.pow(3, a);
        else if (b == 1) return (int)Math.pow(3, a - 1) * 4;
        else return (int)Math.pow(3, a) * 2;
    }
}