package title.可以攻击国王的皇后1222;

import java.util.*;

/**
 * 说实话，如果这题没有出现在每日一题里的话，我可能每次看见这种题都会想逃避。。。
 * 但是看完题解，又感觉做题的方法是何等重要呐！
 */
public class test {
}

//method 1
/*
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int SIDE = 8;
        List<List<Integer>> ans = new ArrayList<>();
        int[][] directions = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        boolean[][] chessboard = new boolean[SIDE][SIDE];
        for (int[] queen : queens) {
            chessboard[queen[0]][queen[1]] = true;
        }

        for (int[] direction : directions) {
            int row = king[0] + direction[0];
            int col = king[1] + direction[1];
            while (row >= 0 && row < SIDE && col >= 0 && col < SIDE) {
                if (chessboard[row][col]) {
                    ans.add(new ArrayList<>(Arrays.asList(row, col)));
                    break;
                } else {
                    row += direction[0];
                    col += direction[1];
                }
            }
        }

        return ans;
    }
}*/


//method 2：广度优先遍历
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int SIDE = 8;
        int[][] directions = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] chessboard = new boolean[SIDE][SIDE];
        Deque<int[]> dq = new ArrayDeque<>();

        for (int[] queen : queens) {
            chessboard[queen[0]][queen[1]] = true;
        }

        for (int i = 0; i < 8; i++) {
            int x = king[0] + directions[i][0];
            int y = king[1] + directions[i][1];

            ////////为什么不判断条件！
            if (x < 0 || y < 0 || x >= SIDE || y >= SIDE) {
                continue;
            }

//            dq.add(new int[] {Arrays.asList(x, y, i)});
            //mind 完了，数组的批量加入都不会了？
            dq.offer(new int[] {x, y, i});
        }

        while (!dq.isEmpty()) {
            int[] t = dq.poll();
            int p = t[0], q = t[1], r = t[2];
            if (chessboard[p][q]) {
                ans.add(new ArrayList<>(Arrays.asList(p, q)));
            } else {
                p += directions[r][0];
                q += directions[r][1];
                ///
                if (p < 0 || q < 0 || p >= SIDE || q >= SIDE) {
                    continue;
                }
                dq.offer(new int[] {p, q, r});
            }
        }

        return ans;
    }
}