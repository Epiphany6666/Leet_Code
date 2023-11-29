package title.打家劫舍198.overWrite01;

public class test {
}

/*
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        f[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.max(f[i - 2] + nums[i - 1], f[i - 1]);
        }
        return f[n];
    }
}*/

class Solution {
    public int rob(int[] nums) {
        int prev = 0, curr = 0;
        for (int num : nums) {
            int temp = Math.max(curr, prev + num);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}