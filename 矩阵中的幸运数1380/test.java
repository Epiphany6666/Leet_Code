package title.矩阵中的幸运数1380;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
}

/*
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] col = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                col[j][i] = matrix[i][j];
            }
        }
        int[][] lucky1 = new int[m][n];
        int[][] lucky2 = new int[m][n];
        for (int i = 0; i < m; i++) {
            int min = Arrays.stream(matrix[i]).min().getAsInt();
            Arrays.fill(lucky1[i], min);
        }

        for (int i = 0; i < n; i++) {
            int max = Arrays.stream(col[i]).max().getAsInt();
            Arrays.fill(lucky2[i], max);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (lucky1[i][j] == lucky2[i][j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}*/

//method 我的方法想复杂了。。。
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        //note 赋最大值、最小值的时候可以看范围
        //cols直接为0
        /*Arrays.fill(rows, Integer.MAX_VALUE);
        Arrays.fill(cols, Integer.MIN_VALUE);*/
        for (int i = 0; i < m; i++) {
            //
            rows[i] = 10001;
            for (int j = 0; j < n; j++) {
                rows[i] = Math.min(rows[i], matrix[i][j]);
                cols[j] = Math.max(cols[j], matrix[i][j]);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == cols[j]) ans.add(matrix[i][j]);
            }
        }
        return ans;
    }
}