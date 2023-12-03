package 周赛.第373场.循环移位后的矩阵相似检查2946;

public class test {
}

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        if  (mat == null || mat.length == 0) return true;
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            if ((i & 1) == 1) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != mat[i][(j + k) % n]) return false;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != mat[i][(j + n - (k % n)) % n]) return false;
                }
            }
        }
        return true;
    }
}