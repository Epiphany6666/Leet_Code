package title.对角线遍历498;

import java.util.ArrayList;
import java.util.List;

public class test {
}

/**
 * 参考题解：Ikaruga
 */
// 观察规律可得，对角线一共会有 m + n - 1 条
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int i = 0;
        int m = mat.length, n = mat[0].length;
//        int[] nums = new int[m * n];
        List<Integer> nums = new ArrayList<>();
        while (i < m + n) {
            int xi = i < m ? i : m - 1;
            int yi = i - xi;
            while (xi >= 0 && yi < n) {
                nums.add(mat[xi][yi]);
                xi--;
                yi++;
            }
            i++;
            if (i >= m + n) break;
            yi = i < n ? i : n - 1;
            xi = i - yi;
            while (yi >= 0 && xi < m) {
                nums.add(mat[xi][yi]);
                xi++;
                yi--;
            }
            i++;
        }
        int[] ans = new int[m * n];
        for (int j = 0; j < nums.size(); j++) {
            ans[j] = nums.get(j);
        }
        return ans;
    }
}