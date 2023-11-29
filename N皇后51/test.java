package title.N皇后51;

import java.util.*;

public class test {
    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }
}

/**
 * 这里有个地方很巧妙：就是依次遍历每一行，然后只通过一个一维数组来记录每一行的哪一列存在皇后！
 */
/*
//method 1：基于集合的回溯
class Solution {
    List<List<String>> ans = new ArrayList<>();
    Set<Integer> col = new HashSet<>();
    Set<Integer> diagonal1 = new HashSet<>();
    Set<Integer> diagonal2 = new HashSet<>();
    int[] queens;
    int n;
    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        this.n = n;
        dfs(0);
        return ans;
    }

    private void dfs(int row) {
        if (row >= n) {
            ans.add(generateBoard());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col.contains(i)) continue;

            int d1 = row - i;
            if (diagonal1.contains(d1)) continue;

            int d2 = row + i;
            if (diagonal2.contains(d2)) continue;

            queens[row] = i;
            col.add(i);
            diagonal1.add(d1);
            diagonal2.add(d2);
            dfs(row + 1);
            queens[row] = -1;
            col.remove(i);
            diagonal1.remove(d1);
            diagonal2.remove(d2);
        }
    }

    private List<String> generateBoard() {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}*/

//method 2：基于位运算的回溯
/*class Solution {
    List<List<String>> ans = new ArrayList<>();
    int n;
    int[] queens;
    public List<List<String>> solveNQueens(int n) {
        int col = 0, diagonal1 = 0, diagonal2 = 0;
        this.n = n;
        queens = new int[n];
        dfs(0, col, diagonal1, diagonal2);
        return ans;
    }

    private void dfs(int row, int col, int diagonal1, int diagonal2) {
        if (row >= n) {
            ans.add(generateBoard());
            return;
        }

        for (int i = 0; i < n; i++) {
            if ((col & (1 << i)) != 0) continue;

            //note 想明白错误的原因了，这里会越界
            int d1 = row - i;
            if ((diagonal1 & (1 << d1)) != 0) continue;

            //note 这里也会越界
            int d2 = row + i;
            if ((diagonal2 & (1 << d2)) != 0) continue;

            queens[row] = i;
            col |= (1 << i);
            diagonal1 |= (1 << d1);
            diagonal2 |= (1 << d2);
            dfs(row + 1, col, diagonal1, diagonal2);
            Integer.bitCount()
        }
    }

    private List<String> generateBoard() {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}*/

/**
 * mind 看完了题解，真的赞不绝口
 * Integer.bitCount()：统计一个数的二进制位有多少个 1
 */
class Solution {
    List<List<String>> ans = new ArrayList<>();
    int n;
    int[] queens;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        queens = new int[n];
        int col = 0, diagonal1 = 0, diagonal2 = 0;
        dfs(0, col, diagonal1, diagonal2);
        return ans;
    }

    private void dfs(int row, int col, int diagonal1, int diagonal2) {
        if (row == n) {
            ans.add(generateBoard());
            return;
        }

        //note 忘记取反啦
//        int availablePosition = ((1 << n) - 1 ) & col | diagonal1 | diagonal2;
//        int availablePosition = col | diagonal1 | diagonal2;
        int availablePosition = ((1 << n) - 1) & (~(col | diagonal1 | diagonal2));
        // question 用这个会抛出越界异常
        // note 我知道原因了，不仅仅前面的数会反转，左边的0也会反转为1啊！
        // int availablePosition = ~(col | diagonal1 | diagonal2);
        while (availablePosition != 0) {
            int position = (availablePosition & (-availablePosition));
            availablePosition = availablePosition & (availablePosition - 1);
            int colum = Integer.bitCount(position - 1);
            queens[row] = colum;
            dfs(row + 1, col | position, (diagonal1 | position) << 1, (diagonal2 | position) >> 1);
            queens[row] = 0;
        }
    }

    private List<String> generateBoard() {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
        }
        return board;
    }
}
   