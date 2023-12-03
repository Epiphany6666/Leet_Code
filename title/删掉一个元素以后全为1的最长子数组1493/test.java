package title.删掉一个元素以后全为1的最长子数组1493;

public class test {
}

//method 1：递推
/*class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len + 1];
//        int[] suffix = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            pre[i] = nums[i - 1] == 1 ? pre[i - 1] + 1 : 0;
        }

        int suf = 0;
        int ans = 0;
        for (int i = len - 1; i >= 0; i++) {
            ans = Math.max(ans, suf +  pre[i]);
            suf = nums[i] == 1 ? suf + 1 : 0;
        }
        return ans;
    }
}*/

//method 2：递推优化
class Solution {
    public int longestSubarray(int[] nums) {
        int p0 = 0, p1 = 0, ans = 0;
        for (int num : nums) {
            if (num == 0) {
                p1 = p0;
                p0 = 0;
            } else {
                p0++;
                p1++;
            }
            ans = Math.max(ans, p1);
        }
        if (ans == nums.length) ans--;
        return ans;
    }
}