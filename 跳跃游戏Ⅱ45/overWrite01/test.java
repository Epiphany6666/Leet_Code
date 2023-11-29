package title.跳跃游戏Ⅱ45.overWrite01;

public class test {
}

class Solution {
    public int jump(int[] nums) {
        int border = 0, maxPosition = 0, step = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPosition = Math.max(maxPosition, maxPosition + nums[i]);
            if (i == border) {
                step++;
                border = maxPosition;
            }
        }
        return step;
    }
}