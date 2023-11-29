package title.爬楼梯70;

/**
 * 我是不是这辈子都学不会动态规划了。。。。。。。。。。。。。。。。。。。。。。。
 */

public class test {
}

//法1：动态规划
/*
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return n;
        int[] f = new int[n + 1];
        f[1] = 1;
//        if (n == 1) return f[n];//忽略了如果是有一级楼梯，这里就会数组越界
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}*/


//法2：递归 - 超时！！！
/*class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}*/

//法3：记忆化 - 可以过
/*class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if (map.containsKey(n)) return map.get(n);
        if (n == 1) return 1;
        if (n == 2) return 2;
        map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return map.get(n);
    }
}*/

/**
 * 我后来才知道map很耗时，所以还是要学会记忆化使用数组的方式
 */
////法3：记忆化 - 写法2
/*class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    //1. 不能这么写！，以下三个只能走一个！
    *//*private int climbStairsMemo(int n, int[] memo) {
        if (n == 1) memo[1] = 1;
        if (n == 2) memo[2] = 2;
        memo[n] = memo[n - 1] + memo[n - 2];
        return memo[n];
    }*//*

   *//* private int climbStairsMemo(int n, int[] memo) {
        if (n == 1) memo[1] = 1;
        else if (n == 2) memo[2] = 2;
//        else memo[n] = memo[n - 1] + memo[n - 2];2. 这里还是要靠递归！！！
        else memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }*//*

    private int climbStairsMemo(int n, int[] memo) {
        //为什么记忆化的条件我也会忘？
        if (memo[n] > 0) return memo[n];
        if (n == 1) memo[1] = 1;
        else if (n == 2) memo[2] = 2;
//        else memo[n] = memo[n - 1] + memo[n - 2];
        else memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }
}*/

//法3：动态规划之滚动数组
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;;
        }
        return second;
    }
}