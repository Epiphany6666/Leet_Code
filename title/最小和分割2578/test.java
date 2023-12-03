package title.最小和分割2578;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public int splitNum(int num) {
        char[] nums = (num + "").toCharArray();
        Arrays.sort(nums);
        int sum = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            sum += nums[l];
            sum += nums[r];
        }
    }
}*/

//第一题，就不会。。。
class Solution {
    public int splitNum(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        Arrays.sort(chars);
        int[] ans = new int[2];

        for (int i = 0; i < chars.length; i++) {
            //不要忘记减0了！
            ans[i % 2] = ans[i % 2] * 10 + chars[i] - '0';
        }
        return ans[0] + ans[1];
    }
}