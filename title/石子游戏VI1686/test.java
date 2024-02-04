package title.石子游戏VI1686;

import java.util.Arrays;

public class test {
}

class Solution {
    public int stoneGameVI(int[] a, int[] b) {
        int n = a.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> a[j] + b[j] - a[i] - a[j]);
        int diff = 0;
        for (int i = 0; i < n; i++) {
            diff += i % 2 == 0 ? a[ids[i]] : -b[ids[i]];
        }
        return Integer.compare(diff, 0);
    }
}