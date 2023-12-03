package title.剑指Offer_04二维数组中的查找;

public class test {
    public static void main(String[] args) {
        new Solution().findNumberIn2DArray(new int[][] {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}}, 5);
    }
}

/*
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //note 1 :没有特判！
        if (matrix.length == 0) {
            return false;
        }

        //note 2:这也能写反啊。。，，
        */
/*for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {*//*

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}*/

/*class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if ()
            for (int j = 0; j < matrix[0].length; j++) {

            }
        }
    }
}*/

//method 2：从左下角开始
/*
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}*/

//method 3：从右上角开始
/*
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length;
        while (i < matrix.length && j >= 0) {
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

//method 4：对每一行都进行二分查找！因为每一行都是升序排列的！
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (search(row, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean search(int[] row, int target) {
        int l = 0, r = row.length - 1;
//        while (l < r) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (row[mid] > target) {
                r = mid - 1;
            } else if (row[mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}