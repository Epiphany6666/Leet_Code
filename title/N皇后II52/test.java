package title.N皇后II52;

import java.util.HashSet;
import java.util.Set;

public class test {
}

//method 1：位运算
class Solution1 {
    int ans = 0;
    public int totalNQueens(int n) {
        dfs(n, 0, 0, 0, 0);
        return ans;
    }

    private void dfs(int n, int row, int col, int dl, int dr) {
        if (row >= n) {
            ans++;
            return;
        }
        int bits = ~(col | dl | dr) & ((1 << n) - 1);
        while (bits > 0) {
            int pick = bits & (-bits);
            dfs(n, row + 1, col | pick, (dl | pick) << 1, (dr | pick) >> 1);
            bits &= bits - 1;
        }
    }
}

//method 2：回溯
class Solution {
    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> dls = new HashSet<>();
        Set<Integer> drs = new HashSet<>();
        return backtrack(n, 0, cols, dls, drs);
    }

    private int backtrack(int n, int row, Set<Integer> cols, Set<Integer> dls, Set<Integer> drs) {
        if (row == n) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cols.contains(i)) continue;
            // note 方向一的斜线为从左上到右下方向，同一条斜线上的每个位置满足行下标与列下标之差相等
            // note 方向二的斜线为从右上到左下方向，同一条斜线上的每个位置满足行下标与列下标之和相等
            int dl = row - i;
            if (dls.contains(dl)) continue;
            int dr = row + i;
            if (drs.contains(dr)) continue;
            cols.add(i);
            dls.add(dl);
            drs.add(dr);
            cnt += backtrack(n, row + 1, cols, dls, drs);
            cols.remove(i);
            dls.remove(dl);
            drs.remove(dr);
        }
        return cnt;
    }
}