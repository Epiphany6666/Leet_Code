package title.找到最高海拔1732;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public int largestAltitude(int[] gain) {
        int len = gain.length;
        int[] height = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            height[i] = height[i - 1] - gain[i - 1];
        }
        return Arrays.stream(height).max().getAsInt();
    }
}*/

//method 1：前缀和
class Solution {
    public int largestAltitude(int[] gain) {
        int pre = 0, ans = 0;
        for (int i : gain) {
            pre += i;
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}