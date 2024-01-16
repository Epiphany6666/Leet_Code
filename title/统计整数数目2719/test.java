package title.统计整数数目2719;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 第一次接触到数位DP的题目，写完还是懵懵懂懂。。。
 */

public class test {
}

// mind 暴力没有考虑到parseInt的越界
class Solution1 {
    public int count(String num1, String num2, int min_sum, int max_sum) {
        int n1 = Integer.parseInt(num1), n2 = Integer.parseInt(num2);
        int ans = 0;
        for (int i = n1; i <= n2; i++) {
            int count = cnt_digit(i);
            if (count >= min_sum && count <= max_sum) ans++;
        }
        return ans;
    }

    private int cnt_digit(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}


// 题解：ylb
class Solution2 {
    // 声明一个常量，表示取模的基数（10^9 + 7）
    private final int mod = (int) 1e9 + 7;

    // 初始化一个二维数组 f，用于存储子问题的解，避免重复计算
    private Integer[][] f;

    // 存储当前处理的数字字符串
    private String num;

    // 存储最小数位和限制 min_sum
    private int min;

    // 存储最大数位和限制 max_sum
    private int max;

    // 主要方法，输入为两个数字字符串 num1 和 num2，以及两个整数 min_sum 和 max_sum
    public int count(String num1, String num2, int min_sum, int max_sum) {
        // 初始化 min_sum 和 max_sum 的值，并将 num2 赋给全局变量 num
        min = min_sum;
        max = max_sum;
        num = num2;

        int n = num2.length();
        // 初始化动态规划数组 f
        f = new Integer[n][Math.min(9 * n, max_sum) + 1];

        // 计算 num2 对应的好整数数量，并存储在 a 中
        int a = dfs(0, 0, true);

        // 将 num1 减一后转换为字符串并赋给 num，重新初始化 f 数组
        num = new BigInteger(num1).subtract(BigInteger.ONE).toString();
//        f = new Integer[23][220];
        f = new Integer[n][Math.min(9 * n, max_sum) + 1];

        // 计算 num1-1 对应的好整数数量，并存储在 b 中
        int b = dfs(0, 0, true);

        // 返回满足条件的好整数差值对模的结果
        return (a - b + mod) % mod;
    }

    // 深度优先搜索实现动态规划辅助函数
    private int dfs(int pos, int s, boolean limit) {
        // 如果遍历到字符串末尾，则判断当前数位和是否满足条件并返回计数结果
        if (pos >= num.length()) {
            return s >= min && s <= max ? 1 : 0;
        }

        // 如果该状态已经计算过并且不是在严格限制的情况下，则直接返回之前保存的结果
        if (!limit && f[pos][s] != null) {
            return f[pos][s];
        }

        // 初始化答案 ans
        int ans = 0;

        // 根据当前是否是严格限制（即 num1 或 num2），确定当前位置的最大可能数字
        int up = limit ? num.charAt(pos) - '0' : 9;

        // 遍历当前位置所有可能的数字 i，并递归计算下一位数位和
        for (int i = 0; i <= up; ++i) {
            ans = (ans + dfs(pos + 1, s + i, limit && i == up)) % mod;
        }

        // 如果不在严格限制情况下，将计算得到的结果存入 f 数组中以便后续使用
        if (!limit) {
            f[pos][s] = ans;
        }

        // 返回当前状态下好整数的数量
        return ans;
    }
}

// method 数位DP
class Solution {
    private static final int mod = 1_000_000_007;
    private int max, min;
    private String num;
    private Integer[][] f;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        max = max_sum;
        min = min_sum;
        num = num2;
        int n = num.length();
//        f = new Integer[n][Math.min(9 * n, max) + 1];
        f = new Integer[23][220];
        int a = dfs(0, 0, true);

        num = new BigInteger(num1).subtract(BigInteger.ONE).toString();
        n = num.length();
//        f = new Integer[n][Math.min(9 * n, max) + 1];
        f = new Integer[23][220];
        int b = dfs(0, 0, true);
        return (a - b + mod) % mod;
    }

    private int dfs(int pos, int s, boolean limit) {
        if (pos >= num.length()) {
            return s >= min && s <= max ? 1 : 0;
        }

        if (!limit && f[pos][s] != null) {
            return f[pos][s];
        }

        int ans = 0;
        int up = limit ? num.charAt(pos) - '0' : 9;
        for (int i = 0; i <= up; i++) {
            ans = (ans + dfs(pos + 1, s + i, limit && (i == up))) % mod;
        }
        if (!limit) f[pos][s] = ans;
        return ans;
    }
}