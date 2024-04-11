package title.摆动序列376;

public class test {
}

/**
 * 参考题解：lghh
 */
// method 动态规划
// mind 根本想不到啊。。。
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int up = 1, down = 1;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                up = down + 1;
            } else if (nums[i + 1] < nums[i]) {
                down = up + 1;
            }
        }
        return n == 0 ? 0 : Math.max(up, down);
    }
}