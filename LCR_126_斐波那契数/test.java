package title.LCR_126_斐波那契数;

public class test {
}

/*
class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int p0 = 0, p1 = 1, ans = 0, MOD = (int)1e9 + 7;
        for (int i = 2; i <= n; i++) {
            ans = (p0 + p1) % MOD;
            p0 = p1;
            p1 = ans;
        }
        return ans;
    }
}*/

//method 简化
class Solution {
    public int fib(int n) {
        int p0 = 0, p1 = 1, ans = 0, MOD = (int)1e9 + 7;
        for (int i = 0; i < n; i++) {
            ans = (p0 + p1) % MOD;
            p0 = p1;
            p1 = ans;
        }
        return p0;
    }
}