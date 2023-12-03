package 双周赛.第113场双周赛.统计距离为k的点对6988;

import java.util.List;

public class test {
}

class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int k = 0;
        for (int i = (nums.size() + 1) / 2; i < nums.size(); i++) {
            k += nums.get(k) < nums.get(i) ? 1 : 0;
        }
        return nums.size() - 2 * k;
    }
}