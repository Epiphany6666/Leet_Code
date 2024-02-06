package 周赛.第383场.第1题;

public class test {
}

// mind 看清题目。。。
class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int n = nums.length, ans = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
//            int pre = b;
            b += nums[i];
//            if ((pre > 0 && b < 0) || (pre < 0 && b > 0)) ans++;
            if (b == 0) ans++;
        }
        return ans;
    }
}