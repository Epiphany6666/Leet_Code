package title.完成旅途的最少时间2187;

import java.util.Arrays;

public class test {
}

//method 超时。。。
/*
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        for (int i = 1; ; i++) {
            long ans = 0;
            for (int j = 0; j < time.length; j++) {
                ans += i / time[j];
            }
            if (ans >= totalTrips) {
                return i;
            }
        }
    }
}*/

//method 2：天呐，二分法，真没想到
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
//        int l = 1;
        long l = 1;
        //note 这里一定要强转为long
//        long r = 1L * totalTrips / time[0];
        long r = 1L * totalTrips * time[0];
        while (l <= r) {
//            int mid = l + ((r - l) >> 1);
            long mid = l + ((r - l) >> 1);
            long t = 0;
            for (int i : time) {
                if (mid < i) break;
                t += mid / i;
            }
            if (t < totalTrips) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}