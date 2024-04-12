package 周赛.第370场.第一题_找到冠军I2923;

public class test {
}

/*
class Solution {
    public int findChampion(int[][] edges) {
        int m = edges.length, n = edges[0].length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += edges[i][j];
            }
            if (sum == 0) return i;
        }
        return -1;
    }
}*/

//method 2：
class Solution {
    public int findChampion(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 0; j < n; j++) {
            boolean ok = true;
            for (int i = 0; i < m; i++) {
                if (i != j && grid[i][j] == 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) return j;
        }
        return -1;
    }
}