package title.无重叠区间435;

import java.util.Arrays;

public class test {
}

//method 1：动态规划
//不理解，官解居然没通过，因为时间太长了，，，
/*
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //note 特判
        if (intervals.length == 0)  return 0;
        Arrays.sort(intervals, (i, j) -> (i[0] - j[0]));
        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
//                if (intervals[j][1] < intervals[i][0]) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
}*/

//method 2：贪心
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;
        Arrays.sort(intervals, (i, j) -> (i[1] - j[1]));

        int ans = 1, right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}