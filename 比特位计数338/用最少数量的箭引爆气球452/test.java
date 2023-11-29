package title.用最少数量的箭引爆气球452;

import java.util.Arrays;
import java.util.Comparator;

public class test {
}

/**
 * 当排序左端点行不通的时候为什么不想想排序右端点呢
 * 排序左端点也可以，但是需要逆序排序，并且从后往前遍历
 */

/*
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (i, j) -> (i[0] - j[0]));
        int ans = 0, right = points[0][1];
        int n = points.length;
        for (int i = 1; i < n; i++) {
            if (points[i][0] <= right) ans++;
            right = points[i][1];
        }
        return ans;
    }
}*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        //mind 测试用例：[[-2147483646,-2147483645],[2147483646,2147483647]]
        //mind 这都要考虑越界问题。。
//        Arrays.sort(points, (i, j) -> (i[1] - j[1]));

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int ans = 1, right = points[0][1];
        int n = points.length;
        for (int i = 0; i < n; i++) {
            if (points[i][0] > right) {
                ans++;
                right = points[i][1];
            }
        }
        return ans;
    }
}