package title.LCR_129_字母迷宫;

public class test {
}

/*
class Solution {
    public boolean wordPuzzle(char[][] grid, String target) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == target.charAt(0) && dfs(grid, i, j, target, 1)) return true;
            }
        }
        return false;
    }

//    private boolean dfs(char[][] grid, int i, int j, String target, int depth) {
//        if (depth == target.length()) return true;
//        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) return false;
//        if (grid[i][j] == target.charAt(depth)) return true;
//        char t = grid[i][j];
//        grid[i][j] = ' ';
//        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
//        boolean flag = false;
//        for (int k = 0; k < 4; k++) {
//            flag |= dfs(grid, i + dir[k][0], j + dir[k][1], target, depth + 1);
//        }
//        grid[i][j] = t;
//        return flag;
//    }

    private boolean dfs(char[][] grid, int i, int j, String target, int depth) {
        //note 又出现了越界问题、。。。
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != target.charAt(depth))) return false;
        if (depth == target.length() - 1) return true;
//        char t = grid[i][j];
        grid[i][j] = ' ';
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean flag = false;
        for (int k = 0; k < 4; k++) {
            flag |= dfs(grid, i + dir[k][0], j + dir[k][1], target, depth + 1);
        }
//        grid[i][j] = t;
        grid[i][j] = target.charAt(depth);
        return flag;
    }
}*/


class Solution {
    public boolean wordPuzzle(char[][] grid, String target) {
        int m = grid.length, n = grid[0].length;
        //note
        char[] words = target.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(grid, i, j, words, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int i, int j, char[] target, int depth) {
//        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) return false;
//        if (grid[i][j] != target[depth]) return false;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != target[depth]) return false;
        if (depth == target.length - 1) return true;
        grid[i][j] = ' ';
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
//        boolean flag = false;
//        for (int k = 0; k < 4; k++) {
//            flag |= dfs(grid, i + dir[k][0], j + dir[k][1], target, depth + 1);
//        }
        boolean res = dfs(grid, i + 1, j, target, depth + 1) || dfs(grid, i - 1, j,target,  depth + 1) ||
                dfs(grid, i, j + 1, target, depth + 1) || dfs(grid, i , j - 1, target, depth + 1);
        grid[i][j] = target[depth];
        return res;
    }
}