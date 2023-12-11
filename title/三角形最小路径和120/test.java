package title.三角形最小路径和120;

import java.util.List;

public class test {
}

class Solution1 {
    int n;
    List<List<Integer>> triangle;
    int ans = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.n = triangle.size();
        this.triangle = triangle;
        dfs(0, 0, 0);
        return ans;
    }

    private void dfs(int i, int sum, int depth) {
        if (depth == n) {
            ans = Math.min(ans, sum);
            return;
        }
        dfs(i, sum + triangle.get(depth).get(i), depth + 1);
        dfs(i + 1, sum + triangle.get(depth).get(i), depth + 1);
    }
}

//method 1：递归 - 优化写法 （超时）
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int depth) {
        if (depth == triangle.size()) return 0;
        return Math.min(dfs(triangle, i, depth + 1), dfs(triangle, i + 1, depth + 1)) + triangle.get(depth).get(i);
    }
}

//method 2：递归 - 记忆化
class Solution3 {
    //note 这里使用了一个技巧，太妙了！为的就是回避原本mem里面存的就是0
    //    int[][] mem;
    Integer[][] mem;

    public int minimumTotal(List<List<Integer>> triangle) {
        mem = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int depth) {
        if (depth == triangle.size()) return 0;
        //note 这里判断自然就为null，而不是0了
//        if (mem[i][depth] != 0) return mem[i][depth];
        if (mem[i][depth] != null) return mem[i][depth];
        mem[i][depth] = Math.min(dfs(triangle, i, depth + 1), dfs(triangle, i + 1, depth + 1)) + triangle.get(depth).get(i);
        return mem[i][depth];
    }
}

//method 3：动态规划 - 自底向上
class Solution4 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}

//method 4：动态规划 - 空间优化
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}