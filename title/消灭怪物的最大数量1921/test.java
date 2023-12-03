package title.消灭怪物的最大数量1921;

import java.util.Arrays;

public class test {
}

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int ans = 0;
        int n = dist.length;
        int[] arrivalTime = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTime[i] = (dist[i] - 1) / speed[i];
        }

        Arrays.sort(arrivalTime);
        for (int i = 0; i < n; i++) {
            if (arrivalTime[i] < i) {
                return i;
            }
        }
        return n;
    }
}