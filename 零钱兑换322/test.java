package title.零钱兑换322;

/**
 * 本题划重点：是否使用第k个硬币受到之前情况的影响。
 */

public class test {
    public static void main(String[] args) {
//        new Solution().coinChange();
    }
}

/*
//动态规划 - 背包问题
class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] f = new int[len + 1][amount + 1];
        for (int i = 0; i < len; i++) {
            f[i][coins[i]] = 1;
        }

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                f[i][j] = f[i - 1][j];
                if (j - coins[i] + 1 >= 0)
                f[i][j] = Math.min(f[i - 1][j], f[i -1][j - coins[i]] + 1);
            }
        }

        return f[len][amount];
    }
}*/


/*
//先不说有没有写对，但真的很多低级错误
class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] f = new int[len + 1][amount + 1];
        for (int i = 0; i < len; i++) {
            if (coins[i] <= amount)//1.范围
                f[i][coins[i]] = 1;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                f[i][j] = f[i - 1][j];
                if (j - coins[i - 1] >= 0)//2.i和这里有错位
                    f[i][j] = Math.min(f[i - 1][j], f[i -1][j - coins[i - 1]] + 1);
            }
        }

        return f[len][amount];
    }
}*/

/**但是我很好奇，为什么我连递归都没写出？？？
 * 找出了：卡壳的点：每一个coins[i]都要用一次递归，可以用for循环吗
 *
 */
/*class Solution {
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int[] coins, int amount, int count) {
        if (amount < 0) return;
        if (amount == 0) ans = Math.min(ans, count);

        for (int i = 0; i < coins.length; i++) {
            dfs(coins, amount - coins[i], count + 1);
        }
    }
}*/

/**记忆化搜索*/
/*
class Solution {
    Set<String> map = new HashSet<>();
    int ans = 0x3f3f3f3f;
    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);
        return ans == 0x3f3f3f3f ? -1 : ans;
    }

    private void dfs(int[] coins, int amount, int count) {
        String key = amount + "_" + count;
        if (map.contains(key)) return;

        if (amount < 0) return;
        if (amount == 0) ans = Math.min(ans, count);
        map.add(key);

        for (int i = 0; i < coins.length; i++) {
            dfs(coins, amount - coins[i], count + 1);
        }
    }
}*/

/**不明白这里的记忆化搜索为什么还是超时，没有剪枝吗*/
/*
class Solution {
    Set<String> map = new HashSet<>();
    int ans = 0x3f3f3f3f;
    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);
        return ans == 0x3f3f3f3f ? -1 : ans;
    }

    private void dfs(int[] coins, int amount, int count) {
        String key = amount + "_" + count;

        if (amount < 0) return;
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        if (map.contains(key)) return;

        for (int i = 0; i < coins.length; i++) {
            dfs(coins, amount - coins[i], count + 1);
        }
        map.add(key);
    }
}*/

/**
* 终于明白这里为啥不能直接返回了！！！
* 因为虽然在 amount相同的情况下，上一次有比较过，但是count的次数可能不一样！
* 并且也绝对不能那amount和count作为key，因为每一次的count都不一样，跟没有剪枝

 * 我好像也能理解这个记忆化搜索和我的有什么不同了
 * 我的记忆化搜索跟amount前面的count数量有关，但是这个记忆化与前面的数量无关。！保存的是返回值
 */
/*class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return 0;
        int[] memo = new int[amount + 1];
        return findWay(coins, amount, memo);
    }

    private int findWay(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

//        if (memo[amount] == 0) return memo[amount];
        if (memo[amount] != 0) return memo[amount];//记忆化超时的原因
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i], memo);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount];
    }
}*/

/*
class Solution {
    Set<Integer> map = new HashSet<>();
    int ans = 0x3f3f3f3f;
    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);
        return ans == 0x3f3f3f3f ? -1 : ans;
    }

    private void dfs(int[] coins, int amount, int count) {
        int key = amount;

        if (map.contains(key)) return;//如果以前已经比较过了，这次直接return即可

        if (amount < 0) return;
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            dfs(coins, amount - coins[i], count + 1);
        }
        map.add(key);
    }
}
*/

//动态规划，它们都说动态规划就是记忆化搜索1:1的翻译，但每次就是想不到，但看完又会觉得很简单...
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;

        int[] f = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && f[i - coins[j]] < min) {
                    min = f[i - coins[j]] + 1;
                }
            }
            //这里绝对不能就将f[i]替换成-1，否则下一次比较就会有误
//            f[i] = (min == Integer.MAX_VALUE ? -1 : min);
            f[i] = min;
        }
//        return f[amount];
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }
}*/


//动态规划 - 写法2：
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int[] f = new int[amount + 1];
        Arrays.fill(f, amount + 1);

        //注意填充完后，f[0]也要记得初始化
        f[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }
        return f[amount] == amount + 1 ? -1 : f[amount];
    }
}*/

class Solution {
    //memo的定义：在金额为i的情况下，可以凑成的方式数
    int[] memo;
    public int coinChange(int amount, int[] coins) {
        memo = new int[amount + 1];
        return dfs(amount, coins);
    }

    private int dfs(int amount, int[] coins) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (memo[amount] != 0) return memo[amount];
        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
//            int res = dfs(amount - coins[i], coins) + 1;
            int res = dfs(amount - coins[i], coins);//不能在这里 + 1
            if (res >= 0 && cnt > res) {
//                cnt = res;
                cnt = res + 1;//而是要在这里面加1
            }
        }
        memo[amount] = cnt == Integer.MAX_VALUE ? -1 : cnt;
        return memo[amount];
    }
}