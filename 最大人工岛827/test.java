package title.最大人工岛827;

import java.util.HashMap;
import java.util.Map;
/**
 * 真的太多粗心的问题了，来总结一下问题
 * 1.没有考虑既然是从2开始编号，数组没有考虑越界问题
 * 2.如果整个grid都没有0，即整个网格就是一座到，就根本轮不到ans的更新，所以应该每计算一座岛屿的面积就更新一次ans
 * 3.忘记加上拼接两座岛屿的这一块岛屿
 * 4.判断0上下左右四块岛屿是否是同一座岛，不是和grid[i][j]比啊！是和四面八方比
 * 5.最后，如果上下左右的岛屿存在，才需要判断是否是同一座岛屿！！！
 */

/**
 * 好牛，又有一个知识盲区！
 * 如果集合不包含元素 e2，则向此集合添加指定的元素 e，以便 Objects.equals（e， e2）。如果此集合已包含该元素，则调用将保留该集合不变并返回 false。
 */

public class test {
    public static void main(String[] args) {
        new Solution().largestIsland(new int[][] {{1, 1}, {1, 0}});
    }
}

/*
class Solution {
    int idx = 2;
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        int[][] map = new int[n * n + 2][1];

        //给所有岛屿编上号,并把每个岛屿的面积储存到Hash表中
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //mind 天呐，看看我错的什么大错误
//                    map[idx, dfs(grid, i, j)];
                    map[idx][0] = dfs(grid, i, j);
                    //note 所以在这里还要加上ans比较
                    ans = Math.max(ans, map[idx][0]);
                    idx++;
                }
            }
        }

        //遍历每一个grid == 0
        //note 糟糕，忘记考虑万一只有一个岛屿，ans不就进不来了
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, count(grid, map, i, j));
                }
            }
        }
        return ans;
    }

    private int count(int[][] grid, int[][] map, int i, int j) {
        int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0;
        if (i - 1 >= 0 && grid[i][j] != grid[i - 1][j]) {
            cnt1 = map[grid[i - 1][j]][0];
        }
        if (i + 1 < grid.length && grid[i][j] != grid[i + 1][j]) {
            cnt2 = map[grid[i + 1][j]][0];
        }
        if (j - 1 >= 0 && grid[i][j] != grid[i][j - 1]) {
            cnt3 = map[grid[i][j - 1]][0];
        }
        if (j + 1 < grid.length && grid[i][j] != grid[i][j + 1]) {
            cnt4 = map[grid[i][j + 1]][0];
        }
//        return cnt1 + cnt2 + cnt3 + cnt4;
        //note 最后还应该加上拼接之后的岛屿！
        return cnt1 + cnt2 + cnt3 + cnt4 + 1;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid.length)) {
            return 0 ;
        }
        if (grid[i][j] != 1) return 0;
        grid[i][j] = idx;

        return dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j - 1) +
                dfs(grid, i, j + 1) + 1;
    }
}
*/

class Solution {
    int idx = 2;
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int ans = 0;
//        int[][] map = new int[n * n][1];
        //还需要加上1 和 0的位置，因为是从2开始编号的
        int[][] map = new int[n * n + 2][1];

        //给所有岛屿编上号,并把每个岛屿的面积储存到Hash表中
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //mind 天呐，看看我错的什么大错误
//                    map[idx, dfs(grid, i, j)];
                    map[idx][0] = dfs(grid, i, j);
                    //note 所以在这里还要加上ans比较
                    ans = Math.max(ans, map[idx][0]);
                    idx++;
                }
            }
        }

        //遍历每一个grid == 0
        //note 糟糕，忘记考虑万一只有一个岛屿，ans不就进不来了
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, count(grid, map, i, j));
                }
            }
        }
        return ans;
    }

    private int count(int[][] grid, int[][] map, int i, int j) {
        int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0;

        //note 天老爷，这里又出错，不是和grid[i][j]比啊！是和四面八方比！
        //note 那怎么做能和字面八方比呢？
        //用一个hash表来存储岛屿的编号
        Map<Integer, Integer> map1 = new HashMap<>();
        boolean[] visited = new boolean[4];
        /*//上 0
        if (i - 1 >= 0) {
            cnt1 = map[grid[i - 1][j]][0];
            visited[0] = true;
            map1.put(0, grid[i][j]);
        }

        //下 1
        if (i + 1 < grid.length) {
            boolean valid = true;
            for (int k = 0; k < 1; k++) {
                if  (!visited[k] || grid[i + 1][j] == map1.get(k)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                cnt2 = map[grid[i + 1][j]][0];
                visited[1] = true;
                map1.put(0, grid[i][j]);
            }
        }

        //左2
        if (j - 1 >= 0) {
            boolean valid = true;
            for (int k = 0; k < 2; k++) {
                if  (!visited[k] || grid[i][j - 1] == map1.get(k)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                cnt3 = map[grid[i][j - 1]][0];
                visited[2] = true;
                map1.put(0, grid[i][j]);
            }
        }

        //右 3
        if (j + 1 < grid.length) {
            boolean valid = true;
            for (int k = 0; k < 3; k++) {
                if  (!visited[k] || grid[i][j + 1] == map1.get(k)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                cnt4 = map[grid[i][j + 1]][0];
                visited[3] = true;
                map1.put(0, grid[i][j]);
            }
        }
//        return cnt1 + cnt2 + cnt3 + cnt4;
        //note 最后还应该加上拼接之后的岛屿！
        return cnt1 + cnt2 + cnt3 + cnt4 + 1;*/

        //note 是存在才要判断！！！
        //上 0
        if (i - 1 >= 0) {
            cnt1 = map[grid[i - 1][j]][0];
            visited[0] = true;
            //存的应该是上的编码啊！！！
//            map1.put(0, grid[i][j]);
            map1.put(0, grid[i - 1][j]);
        }

        //下 1
        if (i + 1 < grid.length) {
            boolean valid = true;
            for (int k = 0; k < 1; k++) {
                if  (visited[k] && grid[i + 1][j] == map1.get(k)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                cnt2 = map[grid[i + 1][j]][0];
                visited[1] = true;
//                map1.put(1, grid[i][j]);
                map1.put(1, grid[i + 1][j]);
            }
        }

        //左2
        if (j - 1 >= 0) {
            boolean valid = true;
            for (int k = 0; k < 2; k++) {
                if  (visited[k] && grid[i][j - 1] == map1.get(k)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                cnt3 = map[grid[i][j - 1]][0];
                visited[2] = true;
//                map1.put(2, grid[i][j]);
                map1.put(2, grid[i][j - 1]);
            }
        }

        //右 3
        if (j + 1 < grid.length) {
            boolean valid = true;
            for (int k = 0; k < 3; k++) {
                if  (visited[k] && grid[i][j + 1] == map1.get(k)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                cnt4 = map[grid[i][j + 1]][0];
            }
        }
        return cnt1 + cnt2 + cnt3 + cnt4 + 1;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid.length)) {
            return 0 ;
        }
        if (grid[i][j] != 1) return 0;
        grid[i][j] = idx;

        return dfs(grid, i + 1, j) +
        dfs(grid, i - 1, j) +
        dfs(grid, i, j - 1) +
        dfs(grid, i, j + 1) + 1;
    }
}