package title.搜索二维矩阵Ⅱ240;

public class test {
}

/*
//自写 method 1
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;

        while (i < m && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}*/

//自写 method 2 二分查找
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (matrix[i][mid] < target) l = mid + 1;
                else if (matrix[i][mid] > target) r = mid - 1;
                else return true;
            }
        }
        return false;
    }
}