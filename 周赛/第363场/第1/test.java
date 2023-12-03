package 周赛.第363场.第1;

import java.util.List;

public class test {
}

class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int size = nums.size();
        int ans = 0;
        for (int i = 0; i < size; i++) {
            if (cnt(i) == k) ans += nums.get(i);
        }
        return ans;
    }

    private int cnt(int i) {
        int count = 0;
        while (i > 0) {
            if (i % 2 == 1) count++;
            i >>= 1;
        }
        return count;
    }
}