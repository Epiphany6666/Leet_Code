package title.买卖股票的最佳时机Ⅳ188;

import java.util.HashMap;
import java.util.Map;

public class test {
}

//method 1 dfs：超时
/*class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        return dfs(0, 0, 0, k, prices);
    }

    private int dfs(int index, int status, int count, int k, int[] prices) {
        if (index == prices.length || count == k) {
            return 0;
        }
        int a = 0, b = 0, c = 0;
        //保持不动
        a = dfs(index + 1, status, count, k, prices);
        if (status == 1) {
            b = dfs(index + 1, 0, count + 1, k, prices) + prices[index];
        } else {
            //note 买入一支的时候，count不用+1！
//            c = dfs(index + 1, 1, count + 1, k, prices) - prices[index];
            c = dfs(index + 1, 1, count, k, prices) - prices[index];
        }
        return Math.max(Math.max(a, b), c);
    }
}*/

//method 2：记忆化
class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        return dfs(0, 0, 0, k, prices);
    }

    private int dfs(int index, int status, int count, int k, int[] prices) {
        if (index == prices.length || count == k) return 0;

        String str = index + "_" + status + "_" + count;
        if (map.containsKey(str)) return map.get(str);
        int a = 0, b = 0, c = 0;
        //保持不动
        a = dfs(index + 1, status, count, k, prices);
        if (status == 1) {
//            b = dfs(index + 1, 0, count + 1, k, prices);
            b = dfs(index + 1, 0, count + 1, k, prices) + prices[index];
        } else {
//            c = dfs(index + 1, 1, count, k, prices);
            c = dfs(index + 1, 1, count, k, prices) - prices[index];
        }
        map.put(str, Math.max(Math.max(a, b), c));
        return map.get(str);
    }
}