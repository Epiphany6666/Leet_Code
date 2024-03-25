package title.零钱兑换Ⅱ518.overWrite01;

public class test {
}

//method 1：记忆化搜索
class Solution {
    int[] memo;
    public int change(int amount, int[] coins) {
        memo = new int[amount + 1];
        dfs(amount, coins);
        return memo[amount];
    }

    private int dfs(int amount, int[] coins) {
        if (amount < 0) return 0;
        if (memo[amount] != 0) return memo[amount];
        if (amount == 0) return 1;
        int ans = 0;
        for (int i = 0; i < coins.length; i++) {
            ans += dfs(amount - coins[i], coins);
        }
        memo[amount] = ans;
        return memo[amount];
    }
}