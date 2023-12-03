package title.单词搜索_79;

/**
 * 这道题还有一道更普遍的方法：回溯
 */
public class test {
    public static void main(String[] args) {
        new Solution().exist(new char[][] {{'a'}}, "a");
    }
}

/*
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                return dfs(board, word, 0, 0, 0);
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int depth) {
//        if (i < 0 || i > board.length || j < 0 || j > board[0].length) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(depth)) {
            return false;
        }
        if (depth >= word.length() - 1) return true;
        board[i][j] = ' ';
        boolean ans = false;
        //上
        ans |= dfs(board, word, i - 1, j, depth + 1);
        //下
        ans |= dfs(board, word, i + 1, j, depth + 1);
        //左
        ans |= dfs(board, word, i, j - 1, depth + 1);
        //右
        ans |= dfs(board, word, i, j + 1, depth + 1);
        return ans;
    }
}*/


class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int depth) {
        if (depth >= word.length()) return true;
//        if (i < 0 || i > board.length || j < 0 || j > board[0].length) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        //note 不能放这里，因为如果越界了，但是depth又超过了word的长度，这个就不会再判断了！
//        if (depth >= word.length()) return true;
        if (board[i][j] != word.charAt(depth)) {
            return false;
        }
        board[i][j] = ' ';
        /*boolean ans = false;
        //上
        ans |= dfs(board, word, i - 1, j, depth + 1);
        //下
        ans |= dfs(board, word, i + 1, j, depth + 1);
        //左
        ans |= dfs(board, word, i, j - 1, depth + 1);
        //右
        ans |= dfs(board, word, i, j + 1, depth + 1);*/

        //note 写法2
        boolean ans = dfs(board, word, i - 1, j, depth + 1) || dfs(board, word, i + 1, j, depth + 1)
                || dfs(board, word, i, j - 1, depth + 1) || dfs(board, word, i, j + 1, depth + 1);

        //note 3 ：这里必须要将board[i][j]恢复原样
        board[i][j] = word.charAt(depth);
        return ans;
    }
}