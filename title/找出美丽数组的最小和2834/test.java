package title.找出美丽数组的最小和2834;

import java.util.HashSet;
import java.util.Set;

public class test {
}

/**
 * 参考题解：灵神
 * 一定要把k*2放在(n-m-1)的后面 否则当k*2和n特别大时可能会超出限制
 */
class Solution1 {
    public int minimumPossibleSum(int n, int k) {
        // m = min(k // 2, n)
        // 1 .... m      (1 + m) * m / 2
        // k .... k + n - m - 1        (2 * k + n - m - 1) * (n - m) / 2
        long m = Math.min(k / 2, n);
        int mod = 1_000_000_007;
        return (int) ((1 + m) * m / 2 % mod + (n - m - 1 + 2 * k) * (n - m) / 2 % mod) % mod;
    }
}

//method 哈希表已经过不了了。。。
class Solution {
    public int minimumPossibleSum(int n, int target) {
        Set<Integer> set = new HashSet<>();
        long ans = 0;
        for (int i = 1; set.size() < n; i++) {
            if (set.contains(target - i)) continue;
            set.add(i);
            ans += i;
        }
        return (int)(ans % ((int)1e9 + 7));
    }
}