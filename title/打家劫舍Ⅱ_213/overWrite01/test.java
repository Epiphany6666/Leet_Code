package title.打家劫舍Ⅱ_213.overWrite01;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[][] f = new int[n][n];
        f[0][0] = nums[0];
        f[0][1] = 0;
        f[1][1] = nums[1];
        for (int i = 2; i < n; i++) {
            if (i != n - 1)
                f[i][0] = Math.max(f[i - 1][0], f[i - 2][0] + nums[i]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 2][1] + nums[i]);
        }
        return Math.max(f[n - 2][0], f[n - 1][1]);
    }
}*/

/*
//mind 我好像误会错意思了
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[][] f = new int[n + 1][n + 1];
        f[0][0] = nums[0];
        f[0][1] = 0;
        f[1][0] = nums[1];
        for (int i = 2; i <= n; i++) {
            if (i != n - 1)
                f[i][0] = Math.max(f[i - 1][0], f[i - 2][0] + nums[i - 1]);
            if (i != n)
                f[i][1] = Math.max(f[i - 1][1], f[i - 2][1] + nums[i]);
        }
        return Math.max(f[n - 1][0], f[n][1]);
    }
}*/

/*
//mind 这个居然跟f[0][0]，f[1][0]是偷还是不偷的初始化顺序有关！
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[][] f = new int[n + 1][n + 1];
        f[1][0] = nums[0];
        f[0][0] = 0;

        f[0][1] = 0;
        f[1][1] = nums[1];
        for (int i = 2; i <= n; i++) {
            if (i <= n - 1)
                f[i][0] = Math.max(f[i - 1][0], f[i - 2][0] + nums[i - 1]);
            if (i < n)
                f[i][1] = Math.max(f[i - 1][1], f[i - 2][1] + nums[i]);
        }
        return Math.max(f[n - 1][0], f[n - 1][1]);
    }
}*/

//mind 学学大佬简洁的代码
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[1];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
//        int prev = 0, curr = nums[0];
        //note 要从0开始！
        int prev = 0, curr = 0;
        for (int num : nums) {
            int temp = Math.max(prev + num, curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}