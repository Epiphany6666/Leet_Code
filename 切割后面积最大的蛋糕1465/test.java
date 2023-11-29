package title.切割后面积最大的蛋糕1465;

import java.util.Arrays;

public class test {
}

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        return (int)((long)calMax(horizontalCuts, h) * (long)calMax(verticalCuts, w) % ((int)1e9 + 7));
    }

    private int calMax(int[] arr, int h) {
        int ans = 0, pre = 0;
        for (int i : arr) {
            ans = Math.max(ans, i - pre);
            pre = i;
        }
        return Math.max(ans, h - pre);
    }
}