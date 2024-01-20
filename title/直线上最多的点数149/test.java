package title.直线上最多的点数149;

import java.util.HashMap;
import java.util.Map;

public class test {
}

// error 我这个算的是平行线
class Solution1 {
    public int maxPoints(int[][] points) {
        Map<int[], Integer> map = new HashMap<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            for (int[] ints : map.keySet()) {
                if (ints[0] * y == ints[1] * x) {
                    map.put(ints, map.get(ints) + 1);
                } else {
                    map.put(new int[] {x, y}, 1);
                }
            }
        }
        int ans = 0;
        for (Integer value : map.values()) {
            ans = Math.max(ans, value);
        }
        return ans;
    }
}

// method 1：枚举直线 + 枚举统计
class Solution2 {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
//        note 至少有一个点在直线上
//        int ans = 0;
        int ans = 1;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int[] x = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = points[j];
                int cnt = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] z = points[k];
                    if ((y[1] - x[1]) * (y[0] - x[0]) == (y[1] - x[1]) * (y[0] - z[0])) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}

class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int a = points[i][1] - points[j][1], b = points[i][0] - points[j][0];
                int k = gcd(a, b);
                String key = a / k + "_" + b / k;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
//          note 注意加上 i 点
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}