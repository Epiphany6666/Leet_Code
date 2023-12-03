package title.最长连续序列128;

import java.util.Arrays;

public class test {
}

//method 1：排序
//mind 居然一直没看懂题！！！
class Solution {
    public int longestConsecutive(int[] nums) {
        //note 每次都需要判断边界吧，，
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);

        int ans = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            /*if (nums[i] != nums[i - 1] + 1) {
//            if (nums[i] != nums[i - 1]) {
                //note 情况没有完全考虑清楚
//                cnt = 1;
                break;
            }*/
//            cnt++;
            if (nums[i] == nums[i - 1]) continue;
            else if (nums[i] != nums[i - 1] + 1) cnt = 1;
            else cnt++;
            if (cnt > ans) ans = cnt;
        }
        return ans;
    }
}