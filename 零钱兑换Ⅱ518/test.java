package title.零钱兑换Ⅱ518;

/**
 * 题解居然说这是背包问题。。。我真的完全看不出来。。。
 * 好难懂。。。好难懂，真的好难懂啊。。。。
 * 动态规划我到底要什么时候才能学会啊，，，
 */

public class test {
    public static void main(String[] args) {
//        new Solution().coinChange(new int[] {1,2,5}, 11);
    }
}


/*
class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        Arrays.sort(coins);
        dfs(amount, coins, 0);
    }

    private void dfs(int amount, int[] coins, int depth) {

    }
}*/

//法1：递归 - 超时
/*
class Solution {
    int ans = 0;
    Set<Integer> set = new HashSet<>();
    public int change(int amount, int[] coins) {
        dfs(amount, coins, 0);
        return ans;
    }

    public void dfs(int amount, int[] coins, int cnt) {
        if (amount < 0) return;
        if (amount == 0) {
            if (set.contains(cnt)) return;
            set.add(cnt);
            ans++;
        }

        for (int i = 0; i < coins.length; i++) {
            dfs(amount  - coins[i], coins, cnt + 1);
        }
    }
}
*/

/**记忆化，我这样还是超时。。。
 * 我好像有点能明白这里为什么不嫩用amount和cnt作为key了。因为就算cnt不同，但在amount相同的情况下，返回值依旧是一样的
 * 并且也不能在amount相同的情况下就返回，因为还是跟之前的cnt数量有关
 */
/*
class Solution {
    int ans = 0;
    //    Set<Integer> set = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();
    public int change(int amount, int[] coins) {
        dfs(amount, coins, 0);
        return ans;
    }

    public void dfs(int amount, int[] coins, int cnt) {
        String key = amount + "_" + cnt;
        if (map.containsKey(key)) return;

        if (amount < 0) return;
        if (amount == 0) {
            map.put(key, 1);
            ans++;
        }

        for (int i = 0; i < coins.length; i++) {
            dfs(amount  - coins[i], coins, cnt + 1);
        }
    }
}*/

/**
 * 这个不也很明显的和以前的个数有关嘛！！！
 * 并不是不要判断了，而是需要使用memo里记录的值加上后面的值进行判断。
 */
/*
class Solution {
    int[] memo;
    public int change(int amount, int[] coins) {
        memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        dfs(amount, coins, 0);
        return memo[amount] == amount + 1 ? 0 : memo[amount];
    }

    private void dfs(int amount, int[] coins, int cnt) {
        if (memo[amount] != 0) return;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] < 0) continue;
            if (amount - coins[i] == 0) memo[amount] = Math.max(memo[amount], cnt + 1);
            dfs(amount - coins[i], coins, cnt + 1);
        }
    }
}*/

//不知不觉又把这道题写成了零钱兑换Ⅰ。。。求的是最少硬币数。
//但这道题要求的是可以凑成总金额的数量
/*
class Solution {
    //memo的定义：在金额为i的情况下，可以凑成的方式数
    int[] memo;
    public int change(int amount, int[] coins) {
        memo = new int[amount + 1];
        return dfs(amount, coins);
    }

    private int dfs(int amount, int[] coins) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (memo[amount] != 0) return memo[amount];
        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = dfs(amount - coins[i], coins);
            if (res >= 0 && cnt > res) {
                cnt = res + 1;
            }
        }
        memo[amount] = cnt == Integer.MAX_VALUE ? 0 : cnt;
        return memo[amount];
    }
}*/

/*
class Solution {
    //memo定义：前k个硬币凑齐金额i的组合数
    int[][] memo;
    public int change(int amount, int[] coins) {
        dfs(amount, coins, 0);
    }

    private void dfs(int amount, int[] coins, int count) {
        if (amount < 0) return;

    }
}*/


//记忆化搜索还是不会写，写一下动态规划吧
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            dp[amount][0] = 1;
        }
        /*for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {*/
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
//                    if (j > coins[i]) {
                    if (j > coins[i - 1]) {
//                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - coins[i]];
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - coins[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
            }
        }
        return dp[coins.length][amount];
    }
}