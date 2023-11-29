package title.跳跃游戏55;

public class test {
}

/*
class Solution {
    public boolean canJump(int[] nums) {
        int border = 0, maxJump = 0;
        boolean[] dp = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxJump = Math.max(maxJump, nums[i]);

        }
    }
}*/

//mind 之前做过一次类似的题，现在做怎么还是不会
class Solution {
    public boolean canJump(int[] nums) {
        int maxPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxPosition) return false;
            maxPosition = Math.max(maxPosition, i + nums[i]);
        }
        return true;
    }
}