package title.不同路径III980;

import java.util.HashMap;
import java.util.Map;

/**
 * 总结
 * 明明可以写对，看见是困难题就不敢动笔写？
 * 1.虽然写对了，但代码仍然有很多可以改进的地方，其实要不是他们昨天在群里说这道题的解法，我可能自己写完这道题就跑路了，根本不会去参考大佬的写法。
 * 2.看完了大佬的代码，真的是，太巧秒了！！！再看看我的，什么垃圾代码啊
 */
public class test {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};
        System.out.println(new Solution().uniquePathsIII(grid));
    }
}

//dfs自写
/*class Solution {
    int ans;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int x = 0;
        int y = 0;
        out:for (int i = 0; i < m; i++) {//找到起始方格
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    break out;
                }
            }
        }
        revision(grid, x, y, m, n);//x有n个，y有m个
        return ans;
    }

    public void revision(int[][] grid, int x, int y, int m, int n) {
        if (grid[x][y] == 2) {
            if (noZero(grid, m, n)) {
                ans += 1;
            }
            return;
        }
        grid[x][y] = -1;//走过的路设为-1
        if (x > 0 && grid[x - 1][y] != -1) {
            int temp = grid[x - 1][y];
            revision(grid, x - 1, y, m, n);
            grid[x - 1][y] = temp;//回溯,不一定是等于0！！！
        }
        if (x < m - 1 && grid[x + 1][y] != -1) {
            int temp = grid[x + 1][y];
            revision(grid, x + 1, y, m, n);
            grid[x + 1][y] = temp;
        }
        if (y > 0 && grid[x][y - 1] != -1) {
            int temp = grid[x][y - 1];
            revision(grid, x, y - 1, m, n);
            grid[x][y - 1] = temp;
        }
        if (y < n - 1 && grid[x][y + 1] != -1) {
            int temp = grid[x][y + 1];
            revision(grid, x, y + 1, m, n);
            grid[x][y + 1] = temp;
        }
    }

    public boolean noZero(int[][] grid, int m, int n) {//grid是否全走过
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}*/

/*
//dfs看大佬再写
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int count0 = 0;//统计格子为0的个数
        int sx = -1, sy = -1;//均设置初始值为-1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) count0++;
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs(grid, sx, sy, count0 + 1);//为什么要把起点也算上？
    }

    public int dfs(int[][] grid, int x, int y, int left) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {//不合法的情况
            return 0;
        }
        if (grid[x][y] == 2) {
            if (left == 0) return 1;
            else return 0;
        }
        grid[x][y] = -1;
        int ans = dfs(grid, x + 1, y, left - 1) + dfs(grid, x - 1, y, left - 1)
                + dfs(grid, x, y + 1, left - 1) + dfs(grid, x, y - 1, left - 1);
        grid[x][y] = 0;
        return ans;
    }
}*/

/**
 * 看完灵神的第二种方法，只能感叹，真的！太!巧妙了！！！
 */
//法二：状态压缩+记忆化搜索
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int uniquePathsIII(int[][] grid) {
        int vis = 0;
        int m = grid.length;
        int n = grid[0].length;
        int sx = -1, sy = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    vis |= 1 << (i * n + j);
                }
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs(grid, sx, sy, vis);
    }

    public int dfs(int[][] grid, int x, int y, int vis) {
        int m = grid.length;
        int n = grid[0].length;
        int p = x * n + y;
//        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1) {//不合法
        //ps:注意这里不再是否为判断-1！！！
        if (x < 0 || x >= m || y < 0 || y >= n || (vis >> p & 1) > 0) {//不合法
            return 0;
        }
        vis |= 1 << p;//标记走过
        if (grid[x][y] == 2) {
            return vis == (vis | (1 << m * n) - 1) ? 1 : 0;//这里一定要记得加括号，<<优先级小于-
        }
        int key = p << m * n | vis;
        if (map.containsKey(key)) return map.get(key);
        int ans = dfs(grid, x + 1, y, vis) + dfs(grid, x - 1, y, vis)
                + dfs(grid, x, y + 1, vis) + dfs(grid, x, y - 1, vis);
        map.put(key, ans);
        return ans;
    }
}