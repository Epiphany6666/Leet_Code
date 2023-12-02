package Leet_Code.拼车1094.overWrite01;

public class test {
}

//method 1：暴力
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] sites = new int[1001];
        for (int[] trip : trips) {
            for (int i = trip[1]; i < trip[2]; i++) {
                sites[i] += trip[0];
                if (sites[i] > capacity) return false;
            }
        }
        return true;
    }
}

//method 2：差分数组
class Solution2 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] sites = new int[1001];
        for (int[] trip : trips) {
            sites[trip[1]] += trip[0];
            sites[trip[2]] -= trip[0];
        }

        int total = 0;
        for (int i = 0; i < 1001; i++) {
            total += sites[i];
            if (total > capacity) return false;
        }
        return true;
    }
}