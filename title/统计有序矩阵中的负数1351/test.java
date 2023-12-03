package title.统计有序矩阵中的负数1351;

public class test {
}

/*
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = m - 1, j = 0; i >= 0 && j < n; ) {
            if (grid[i][j] < 0) {
                ans += n - j;
                i--;
            } else {
                j++;
            }
        }
        return ans;
    }
}*/

//method 2：二分查找
class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for (int[] row : grid) {
            ans += bisect(row);
        }
        return ans;
    }

    private int bisect(int[] row) {
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
//            if (row[mid] > 0) {
            if (row[mid] > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l == row.length ? 0 : row.length - l;
    }
}