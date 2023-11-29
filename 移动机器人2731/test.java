package title.移动机器人2731;

import java.util.Arrays;

public class test {
}

class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int n = s.length();
        long Mod = (long) 1e9 + 7;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
//            nums[i] += s.charAt(i) == 'L' ? 1 : -1;
//            a[i] += s.charAt(i) == 'L' ? 1 : -1;
            //note 这里记得强转为long
            a[i] = (long)nums[i] + s.charAt(i) == 'L' ? -d : d;
        }

//        Arrays.sort(nums);
        Arrays.sort(a);
        //note 这个技巧好，先用long，再强转为int
        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + i * a[i] - sum) % Mod;
            sum += a[i];
        }
        return (int)ans;
    }
}