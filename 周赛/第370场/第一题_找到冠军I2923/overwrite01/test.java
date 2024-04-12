package 周赛.第370场.第一题_找到冠军I2923.overwrite01;

public class test {
}

class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[j][i];
            }
            if (sum == 0) return i;
        }
        return -1;
    }
}