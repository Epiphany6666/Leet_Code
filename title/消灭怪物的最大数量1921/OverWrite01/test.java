package title.消灭怪物的最大数量1921.OverWrite01;

import java.util.Arrays;

public class test {
}

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTime = new int[n];
        for (int i = 0; i < n; i++) {
            //不打括号是吧，犯这种低级错误
//            arrivalTime[i] = dist[i] - 1 / speed[i];
            arrivalTime[i] = (dist[i] - 1) / speed[i];
        }

        Arrays.sort(arrivalTime);
        for (int i = 0; i < n; i++) {
            if (arrivalTime[i] < i) return i;
        }
        return n;
    }
}