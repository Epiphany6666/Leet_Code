package 周赛.第370场.第二题_找到冠军II2924;

public class test {
}

class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] weak = new boolean[n];
        for (int[] edge : edges) {
            weak[edge[1]] = true;
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (!weak[i]) {
                if (ans != -1) return -1;
                ans = i;
            }
        }
        return ans;
    }
}