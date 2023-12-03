package title.青蛙过河403.overWrite01;

public class test {
    public static void main(String[] args) {
        new Solution().canCross(new int[] {0,1,2,3,4,8,9,11});
    }
}

//TODO 错了，青蛙跳的是单位，而不是石子的单位，是数组的单位！！！，搞混了。。
/*
class Solution {
    Set<Integer> set = new HashSet<>();
    boolean ans = false;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int stone : stones) {
            set.add(stone);
        }
        if (!set.contains(1)) return false;

        for (int i = 0; i <= 1; i++) {
            dfs(n, 1, 1 + i);
        }

        return ans;
    }

    private void dfs(int n, int cur, int step) {
        if (cur == n) ans = true;
        if (cur > n) return;

        for (int i = -1; i <= 1; i++) {
            if (step == 1 && i == -1) continue;
            if (set.contains(cur + step + i))
                dfs(n, cur + step + i, step + i);
        }
    }
}*/

//method 1：递归
//note 写对了，但是超时
/*
class Solution {
    Map<Integer, Integer> set = new HashMap<>();
    boolean ans = false;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            int stone = stones[i];
            set.put(stone, i);
        }
        if (!set.containsKey(1)) return false;

        //NOTE
        //要明确step的定义指的是前一步跳了多少步来到的这一步。
        dfs(stones, 1, 1);

        return ans;
    }

    private void dfs(int[] stones, int cur, int step) {
        if (cur == stones.length - 1) {
            ans = true;
            return;
        }

        for (int i = -1; i <= 1; i++) {
            if (step == 1 && i == -1) continue;
            int next = stones[cur] + step + i;
            if (set.containsKey(next))
                dfs(stones, set.get(next), step + i);
        }
    }
}*/

//method 2：记忆化搜索
//note 这个记忆化没有返回值，居然也过了，但是 '322. 零钱兑换' 这题我就没有过，重新思考一下为什么吧，原因是322题跟以前的状态有关！
/*class Solution {
    Map<Integer, Integer> set = new HashMap<>();
    Set<String> set1 = new HashSet<>();
    boolean ans = false;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            int stone = stones[i];
            set.put(stone, i);
        }
        if (!set.containsKey(1)) return false;

        //NOTE
        //要明确step的定义指的是前一步跳了多少步来到的这一步。
        dfs(stones, 1, 1);

        return ans;
    }

    private void dfs(int[] stones, int cur, int step) {
        if (cur == stones.length - 1) {
            ans = true;
            return;
        }
        String key = cur + "_" + step;
        if (set1.contains(key)) return;

        for (int i = -1; i <= 1; i++) {
            if (step == 1 && i == -1) continue;
            int next = stones[cur] + step + i;
            if (set.containsKey(next))
                dfs(stones, set.get(next), step + i);
        }
        set1.add(key);
    }
}*/

//method 4：动态规划！ - 写这个我真的是太害怕了。。。今天一定要自己写出来！
//mind 又想看解析，但我真觉得你是可以写出来的。再好好想想。
//mind  看题解也看不进啊。。。
/*
class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        //处于cur，上一步是k，是否能到达第n块石头
        boolean[][][] f = new boolean[n + 1][1][stones[n - 1] + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        if (!map.containsKey(1)) return false;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= stones[n - 1]; j++) {
                for (int k = -1; k <= 1; k++) {
                    if ()
                }
            }
        }
    }
}*/

//mind 好吧，这个我承认，我真的想不出。。
class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] f = new boolean[n + 1][n + 1];
        if (stones[1] != 1) return false;
        f[1][1] = true;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int k = stones[i] - stones[j];

                if (k <= j + 1) {
                    f[i][j] = f[j - 1][k - 1] || f[j][k] || f[j][k + 1];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (f[n][i]) return true;
        }
        return false;
    }
}