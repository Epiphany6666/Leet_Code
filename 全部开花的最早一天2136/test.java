package title.全部开花的最早一天2136;

import java.util.Arrays;

public class test {
}

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        //note 这里如果写int，下面排序的地方就会报错
//        int[] idx = new int[plantTime.length];
        Integer[] idx = new Integer[plantTime.length];
        for (int i = 0; i < plantTime.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> (growTime[j] - growTime[i]));
        int ans = 0, days = 0;
        for (int i : idx) {
            days += plantTime[i];
            ans = Math.max(ans, days + growTime[i]);
        }
        return ans;
    }
}