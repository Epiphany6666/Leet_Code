package title.矩阵置零73;

import java.util.ArrayList;
import java.util.List;

public class test {
}

//method 1：自写
//mind 看完题解后，还有很多用来标记一列是否有0，比如可以用两个set
/*
class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        //记录所有的0的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) list.add(new int[] {i, j});
            }
        }

        for (int[] i : list) {
            int x = i[0];
            int y = i[1];
            for (int j = 0; j < m; j++) {
                matrix[j][y] = 0;
            }
            for (int j = 0; j < n; j++) {
                matrix[x][j] = 0;
            }
        }
    }
}*/

//method 以下皆为官方题解的答案
//method 1：使用标记数组
/*
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}*/

//method 2：使用两个变量标记
//todo 使用矩阵的第一行和第一列代替方法一中的两个标记数组
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstCol0 = false, firstRow0 = false;

        //扫描第一行是否有0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstCol0 = true;
        }

        //扫描第一列是否有0
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) firstRow0 = true;
        }

        //通过第一行和第一列来标记
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRow0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}