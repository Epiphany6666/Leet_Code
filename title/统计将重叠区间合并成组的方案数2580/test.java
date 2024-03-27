package title.统计将重叠区间合并成组的方案数2580;

import java.lang.reflect.Array;
import java.util.Arrays;

public class test {
}

/**
 * 参考题解：灵神
 */
// note 数字范围大了还是需要使用灵神的办法
class Solution1 {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> (a[0] - b[0]));
        int m = 0, maxR = -1, mod = (int)1e9 + 7;
        for (int[] range : ranges) {
            if (range[0] > maxR) {
                m++;
            }
            maxR = Math.max(maxR, range[1]);
        }
        return (int) Math.pow(2, m) % mod;
    }
}

class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> (a[0] - b[0]));
        int ans = 1, maxR = -1, mod = (int)1e9 + 7;
        for (int[] range : ranges) {
            if (range[0] > maxR) {
                ans = ans * 2 % mod;
            }
            maxR = Math.max(maxR, range[1]);
        }
        return ans;
    }
}