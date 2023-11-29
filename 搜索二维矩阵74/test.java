package title.搜索二维矩阵74;

public class test {
}

//method 1：
/*class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (target > matrix[i][j]) {
                i++;
                //note 根本不需要这一行！！！
                //note 每行的第一个整数大于前一行的最后一个整数。
//                j = matrix[0].length - 1;
            }
            else if (target < matrix[i][j]) j--;
            else return true;
        }
        return false;
    }
}*/

//method 2：两次二分查找
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int rowIndex = binarySerchFirstColum(matrix, target);
        if (rowIndex < 0) return false;
        return binarySerchRow(matrix[rowIndex], target);
    }

    private boolean binarySerchRow(int[] row, int target) {
        int i = 0, j = row.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (row[mid] < target) i = mid + 1;
            else if (row[mid] > target) j = mid - 1;
            else return true;
        }
        return false;
    }

    private int binarySerchFirstColum(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (matrix[mid][0] < target) i = mid + 1;
            else if (matrix[mid][0] > target) j = mid - 1;
            else return mid;
        }
        return j - 1;
    }
}