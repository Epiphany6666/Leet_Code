package title.出租车的最大盈利2008;

import java.util.*;

public class test {
}

//method 1：动态规划 + 二分查找
class Solution {
    //note 注意返回值是long
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (i, j) -> (i[1] - j[1]));
        int m = rides.length;
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = binarySearch(rides, i - 1, rides[i][0]);
            dp[i + 1] = Math.max(dp[i], dp[j] + rides[i][j]-rides[i][0] + rides[i][2]);
        }
        return dp[m];
    }

    private int binarySearch(int[][] rides, int high, int target) {
        int low = 0;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (rides[mid][1] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

//method 2：动态规划 + 哈希表
class Solution2 {
    public long maxTaxiEarnings(int n, int[][] rides) {
//        Long[] dp = new Long[n + 1];
        long[] dp = new long[n + 1];
        Map<Integer, List<int[]>> rideMap = new HashMap<>();
        for (int[] ride : rides) {
            rideMap.putIfAbsent(ride[1], new ArrayList<>());
            rideMap.get(ride[1]).add(ride);
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int[] ride : rideMap.getOrDefault(i, new ArrayList<>())) {
                dp[i] = Math.max(dp[i], dp[ride[0]] + ride[1] - ride[0] + ride[2]);
            }
        }
        return dp[n];
    }
}