package title.螺旋矩阵II59;

public class test {
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int o = 0, b = n - 1, l = 0, r = n - 1, t = 1;
        while (true) {
            for(int i = l; i <= r; i++) {
                ans[o][i] = t * t;
                t++;
            }
            if (++o < b) break;

            for (int i = o; i < b; i++) {
                ans[i][r] = t * t++;
            }
            if (--r < l) break;

            for (int i = r; i >= l; i--) {
                ans[b][i] = t * t++;
            }
            if (b-- < o) break;

            for (int i = b; i >= o; i--) {
                ans[i][l] = t * t++;
            }
            if (++l > r) break;
        }
        return ans;
    }
}