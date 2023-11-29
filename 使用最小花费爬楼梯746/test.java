package title.使用最小花费爬楼梯746;

public class test {
}

/*
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        //dp定义：爬到第i层楼梯需要的花费
        */
/*int[][] dp = new int[n + 1][2];
        //1 从第 0 层楼梯开始爬
        //2 从第 1 层楼梯开始爬*//*


        int[] dp = new int[n + 1];
        */
/*for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 2], dp[i - 2] + cost[i - 3]);
        }*//*


        //PS:它是从第0层楼梯开始爬！！！
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
*/

//滚动数组的方式
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int p = 0, q = 0;
        int n = cost.length;

        for (int i = 2; i <= n; i++) {
            int r = Math.min(p + cost[i - 2], q + cost[i - 1]);
            p = q;
            q = r;
        }
        return q;
    }
}