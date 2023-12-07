package title.生命游戏289;

public class test {
    public static void main(String[] args) {
        new Solution2().gameOfLife(new int[][]  {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }
}

//method 1：复制原数组进行模拟
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1},
                {-1, 1}, {-1, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //note 犯了一个很严重的错误。。。找了好久都没找出来，结果在这里，我嘞个豆，每次x，y都需要恢复成i，j，必须定义在下面！
//                int x = i, y = j;
                int live = 0;
                for (int[] d : dir) {
                    int x = i, y = j;
                    x += d[0];
                    y += d[1];
//                    if (!(x >= 0 && x < m && y >= 0 && y < n)) continue;
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (copy[x][y] == 1) live++;
                }
//                if (live < 2) board[i][j] = 0;
//                else if (live == 2 || live == 3) {
//                    if (live == 3) board[i][j] = 1;
//                }
//                else  board[i][j] = 0;
                if (copy[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 0;
                else if  (copy[i][j] == 0 && live == 3) board[i][j] = 1;
            }
        }
    }
}

//method 2：使用额外状态
class Solution2 {
    public void gameOfLife(int[][] board) {
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int[] d : dir) {
                    int x = i + d[0], y = j + d[1];
                    if (!(x >= 0 && x < m && y >= 0 && y < n)) continue;
//                    if (board[i][j] == 1) live++;
                    //note 为什么会这么粗心？？？
//                    if (Math.abs(board[i][j]) == 1) live++;
                    if (Math.abs(board[x][y]) == 1) live++;
                }
                if (board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = -1;
                else if  (board[i][j] == 0 && live == 3) board[i][j] = 2;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 1;
                else if (board[i][j] < 0) board[i][j] = 0;
            }
        }
    }
}