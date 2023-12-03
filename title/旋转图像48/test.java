package title.旋转图像48;

public class test {
}

/*
class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - 1 - i] = ans[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
}*/

//method ：法1写法2
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //note 学到了，数组的初始化还能这样
        int[][] temp = new int[n][];
        for (int i = 0; i < n; i++) {
            //note 数组的深拷贝
            temp[i] = matrix[i].clone();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                matrix[i][j] = temp[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp[i][j];
            }
        }
    }
}