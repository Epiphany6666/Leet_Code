package title.修车的最少时间2594;

public class test {
}

class Solution {
    public long repairCars(int[] ranks, int cars) {//注意这里是long！
        int minRank = ranks[0];
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
        }
        long left = 0;
        long right = (long)minRank * cars * cars;
        while (left <= right) {
            long mid = (left + right) >> 1;
            /*if (cars >= Math.sqrt(left / minRank)) {
                right = mid;
            } else {
                left = mid;
            }*/

            int s = 0;
            for (int rank : ranks) {
                s += Math.sqrt(mid / rank);
            }
            if (cars >= s) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}