package title.需要添加的硬币的最小数量2952;

import java.util.Arrays;

public class test {
}

/**
 * 参考题解：灵茶山艾府
 */
// mind 几个月前写的，现在又忘记了。。。
class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int ans = 0, i = 0, s = 1;
        while (s <= target) {
//            if (i < coins.length && coins[i] <= target) {
            if (i < coins.length && coins[i] <= s) {
                s += coins[i++];
            } else {
                s *= 2;
                ans++;
            }
        }
        return ans;
    }
}