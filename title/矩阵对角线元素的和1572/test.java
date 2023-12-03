package title.矩阵对角线元素的和1572;

public class test {
}

/**
 * 总结：
 * 1.总是喜欢把问题想的太复杂，，
 *   明明if (i != n - 1 - i)就能解决问题。
 */
/*
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
//            if (n % 2 == 0 || i != n / 2)
            if (i != n - 1 - i)
            res += mat[i][i];
            res += mat[i][n - 1 - i];
        }
        return res;
    }
}
*/

class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += mat[i][i] + mat[i][n - 1 - i];
        }
        return res - mat[n / 2][n / 2] * (n & 1);//太巧妙了
    }
}