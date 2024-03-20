package title.数组元素的最小非零乘积1969;

public class test {
}

/**
 * 参考题解：灵神
 */
// method ：贪心 + 快速幂
class Solution1 {
    private final static int mod = (int) 1e9 + 7;
    private long pow (long x, long p) {
        x %= mod;
        long ans = 1;
        while (p > 0) {
            if ((p & 1) == 1) ans = (ans * x) % mod;
//            ans = ans * x % mod;
            x = x * x % mod;
            p >>= 1;
        }
        return ans % mod;
    }
    public int minNonZeroProduct(int p) {
        long k = (1L << p) - 1;
        return (int) (k % mod * pow(k - 1, (long) Math.pow(2, p - 1) - 1) % mod);
    }
}

// method：根据大佬改写
class Solution {
    private final static int mod = (int) 1e9 + 7;
    private long pow (long x, long p) {
        x %= mod;
        long ans = 1;
        while (p > 0) {
            if ((p & 1) == 1) ans = (ans * x) % mod;
            x = x * x % mod;
            p >>= 1;
        }
        return ans % mod;
    }
    public int minNonZeroProduct(int p) {
        long k = (1L << p) - 1;
        return (int) (k % mod * pow(k - 1, (1L << (p - 1)) - 1) % mod);
    }
}