package title.阈值距离内邻居最少的城市1334;

import java.util.Arrays;

public class test {
}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] floyd = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(floyd[i], Integer.MAX_VALUE);
        for (int[] e : edges) {
            floyd[e[0]][e[1]] = e[2];
            floyd[e[1]][e[0]] = e[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || floyd[i][k] == Integer.MAX_VALUE || floyd[k][j] == Integer.MAX_VALUE) continue;
                    if (floyd[i][k] + floyd[k][j] < floyd[i][j]) floyd[i][j] = floyd[i][k] + floyd[k][j];
                }
            }
        }

        int ret = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && floyd[i][j] <= distanceThreshold) cnt++;
            }
            //note 由于要用最大的
//            if (cnt < min) {
            if (cnt <= min) {
                min = cnt;
                ret = i;
            }
        }
        return ret;
    }
}