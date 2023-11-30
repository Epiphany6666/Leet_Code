package Leet_Code.找出叠涂元素2661;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
}

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        if (mat == null || mat.length == 0) return 0;
        int m = mat.length, n = mat[0].length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[] {i, j});
            }
        }

        //note 取名取的真乱
//        int[] cols = new int[m], rows = new int[n];
//        for (int i = 0; i < m * n; i++) {
//            int[] pos = map.get(arr[i]);
//            cols[pos[0]]++;
////            if (cols[pos[0]] == m) return i;
//            if (cols[pos[0]] == n) return i;
//            rows[pos[1]]++;
//            if (rows[pos[1]] == m) return i;
//        }

        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m * n; i++) {
            int[] pos = map.get(arr[i]);
            rows[pos[0]]++;
            if (rows[pos[0]] == n) return i;
            cols[pos[1]]++;
            if (cols[pos[1]] == m) return i;
        }
        return -1;
    }
}