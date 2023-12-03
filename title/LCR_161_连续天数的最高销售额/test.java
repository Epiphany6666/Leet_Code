package title.LCR_161_连续天数的最高销售额;

public class test {
}

//method 1：动态规划
/*
class Solution {
    public int maxSales(int[] sales) {
        int pre = Integer.MIN_VALUE, ans = Integer.MIN_VALUE;
        for (int sale : sales) {
            pre = Math.max(pre + sale, sale);
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}*/

//method ：动态规划 另一种写法
/*
class Solution {
    public int maxSales(int[] sales) {
        int res = sales[0];
        for (int i = 1; i < sales.length; i++) {
            sales[i] += Math.max(sales[i - 1], 0);
            res = Math.max(res, sales[i]);
        }
        return res;
    }
}*/

//method 1：暴力1:
/*class Solution {
    public int maxSales(int[] sales) {
        int len = sales.length, ans =  sales[0];
        for (int i = 0; i < len; i++) {
            //note 并且等号不能放在上面，而应该放在底下，实例：[-1]
//            for (int j = i; j <= len; j++) {
            for (int j = i; j < len; j++) {
                int sum = 0;
//                for (int k = i; k < j; k++) {
                for (int k = i; k <= j; k++) {
                    sum += sales[k];
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}*/

//method 2：暴力2
class Solution {
    public int maxSales(int[] sales) {
        int len = sales.length, ans =  sales[0];
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += sales[j];
                if (sum > ans) ans = sum;
            }
        }
        return ans;
    }
}