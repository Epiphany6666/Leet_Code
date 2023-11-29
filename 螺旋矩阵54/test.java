package title.螺旋矩阵54;

import java.util.ArrayList;
import java.util.List;

public class test {
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                ans.add(matrix[t][i]);
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                ans.add(matrix[i][r]);
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {
                ans.add(matrix[b][i]);
            }
//            if (--b > t) break;
            if (--b < t) break;
//            for (int i = b; i <= t; i++) {
            for (int i = b; i >= t; i--) {
                ans.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return ans;
    }
}