package Leet_Code.src.title.使二叉树所有路径值相等的最小代价2673;

public class test                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    {
}

/**
 * 题解：灵神
 * 本应该从上到下递归，把路径和算出来，但由于是满二叉树，只需要写一个循环即可
 */
class Solution {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n / 2; i > 0; i--) {
            ans += Math.abs(cost[i * 2 - 1] - cost[i * 2]);
            cost[i - 1] += Math.max(cost[i * 2 - 1], cost[i * 2]);
        }
        return ans;
    }
}