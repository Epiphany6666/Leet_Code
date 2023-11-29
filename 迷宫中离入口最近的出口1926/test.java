package title.迷宫中离入口最近的出口1926;

import java.util.Deque;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*char[][] maze = {{'+','+','.','+'},
                {'.','.','.','+'}, {
                '+','+','+','.'}};*/
        char[][] maze = {{'.','+'}};
        int[] ent = {0, 0};
        solution.nearestExit(maze, ent);
    }
}

//method DFS
/*
//mind 这么粗心，真不知道自己在做什么
class Solution {
    int ans = Integer.MAX_VALUE;
    public int nearestExit(char[][] maze, int[] entrance) {
        dfs(maze, entrance[0], entrance[1], -1);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(char[][] maze, int i, int j, int distance) {
        if (!(i >= 0 && i < maze.length && j >= 0 && j < maze[0].length)) {
            if (distance != 0) ans = Math.min(ans, distance);
            return;
        }
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < 4; k++) {
            dfs(maze, i + dir[k][0], j + dir[k][1], distance + 1);
        }
    }
}*/

//mind 写出来了，但是超时
/*
class Solution {
    int ans = Integer.MAX_VALUE;
    public int nearestExit(char[][] maze, int[] entrance) {
        dfs(maze, entrance[0], entrance[1], -1);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(char[][] maze, int i, int j, int distance) {
        if (!(i >= 0 && i < maze.length && j >= 0 && j < maze[0].length)) {
            if (distance != 0) ans = Math.min(ans, distance);
            return;
        }
        if (maze[i][j] == '+') return;
        maze[i][j] = '+';
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < 4; k++) {
            dfs(maze, i + dir[k][0], j + dir[k][1], distance + 1);
        }
        maze[i][j] = '.';
    }
}*/


//method BSF，最短路径，为什么想不到BFS？
/*
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int ans = Integer.MAX_VALUE;
        Deque<int[]> q = new LinkedList<>();
        int distance = -1;
        q.offer(entrance);
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
        //   mind 今天怎么回事，这广度优先遍历怎么写的？
            int[] t = q.poll();
            int x = t[0], y = t[1];
            if (!(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length)) {
                if (distance != 0) ans = Math.min(ans, distance);
            }
            if (maze[x][y] == '+') continue;
            maze[x][y] = '+';
            for (int i = 0; i < 4; i++) {
                q.offer(new int[] {x + dir[i][0], y + dir[i][1]});
            }
        }
        return ans;
    }
}
*/


/*class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int ans = Integer.MAX_VALUE;
        Deque<int[]> q = new LinkedList<>();
        int distance = -1;
        q.offer(entrance);
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            distance++;
            while (size-- > 0) {
                int[] t = q.poll();
                int x = t[0], y = t[1];
                if (!(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length)) {
                    //note 调式了很久，才发现是这里的问题！！！当从起点移动了一步后，distance的值已经变为1了！！
                    //note 但如果是写在while的最后面，那就是0
//                    if (distance > 1) ans = Math.min(ans, distance);
                    if (distance > 1) ans = Math.min(ans, distance);
                    continue;
                }
                if (maze[x][y] == '+') continue;
                maze[x][y] = '+';
                for (int i = 0; i < 4; i++) {
                    q.offer(new int[]{x + dir[i][0], y + dir[i][1]});
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans - 1;
    }*/
//}


class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Deque<int[]> q = new LinkedList<>();
        int distance = -1;
        q.offer(entrance);
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] t = q.poll();
                int x = t[0], y = t[1];
                if (!(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length)) {
                    if (distance != 0) return distance;
                    //note 注意不符合条件要continue！
                    continue;
                }
                if (maze[x][y] == '+') continue;
                maze[x][y] = '+';
                for (int i = 0; i < 4; i++) {
                    q.offer(new int[]{x + dir[i][0], y + dir[i][1]});
                }
                distance++;
            }
        }
        return -1;
    }
}