package 周赛.第374场.需要添加的硬币的最小数量100153;

import java.util.Arrays;

/**
 * 思维题真做不来。。
 * 参考题解＋视频：灵茶山艾府
 */
public class test {
}

class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int s = 1, i = 0, ans = 0;
        //当s - 1 >= target，就表示 [1,target]都有了
        //s > target就退出循环
        while (s <= target) {
            if (i < coins.length && coins[i] <= s) {
                s += coins[i];
                i++;
            } else {
                s *= 2;
                ans += 1;
            }
        }
        return ans;
    }
}