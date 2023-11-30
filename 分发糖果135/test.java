package Leet_Code.分发糖果135;

import java.util.Arrays;

public class test {
}

class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len], right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        }

//        int count = 0;
        int count = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}