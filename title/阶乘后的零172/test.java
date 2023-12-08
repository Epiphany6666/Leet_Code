package title.阶乘后的零172;

public class test {
    public static void main(String[] args) {
        new Solution().trailingZeroes(5);
    }
}

class Solution {
    public int trailingZeroes(int n) {
        int factorial = ret(n);
        int ans = 0;
        while (factorial % 10 == 0) {
            ans++;
            factorial /= 10;
        }
        return ans;
    }

    private int ret(int n) {
        if (n == 1) return 1;
        return n * ret(n - 1);
    }
}

//method 1：遍历 [1,n][1,n][1,n] 的所有 5 的倍数
class Solution2 {
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0 ; x /= 5) {
                ans++;
            }
        }
        return ans;
    }
}

//method 2：优化
class Solution3 {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}