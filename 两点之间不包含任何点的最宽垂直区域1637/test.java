package title.两点之间不包含任何点的最宽垂直区域1637;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = points[i][0];
        }
        Arrays.sort(x);

        int max = 0;
        for (int i = 1; i < n; i++) {
            if (x[i] == x[i - 1]) continue;
            max = Math.max(max, x[i] - x[i - 1]);
        }
        return max;
    }
}*/

//method ：自写优化
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (i, j) -> (i[0] - j[0]));
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            ans = Math.max(ans, points[i + 1][0] - points[i][0]);
        }
        return ans;
    }
}