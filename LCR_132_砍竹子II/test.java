package title.LCR_132_砍竹子II;

public class test {
}

/*
//method 1：动态规划，已经行不通了，要对大数求余
class Solution {
    public int cuttingBamboo(int len) {
        int Mod = (int)1e7 + 7;
        int[] dp = new int[len + 1];
        for (int i = 2; i <= len; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (j - i), j * dp[i - j]) % Mod);
            }
        }
        return dp[len];
    }
}*/

class Solution {
    public int cuttingBamboo(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = (int)1e9 + 7;
        long rem = 1, x = 3;
        for (int i = n / 3 - 1; i > 0; i /= 2) {
            if (i % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if (b == 0) return (int)(rem * 3 % p);
        else if (b == 1)  return (int)(rem * 4 % p);
        else return (int)(rem * 3 * 2 % p);
    }
}