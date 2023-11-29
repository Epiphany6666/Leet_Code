package title.跳跃游戏Ⅱ45;

public class test {
}

//method 第一个想到的绝对是动态规划！
//mind 我错了，，不是动态规划，是贪心，，，
class Solution {
    public int jump(int[] nums) {
        //记录边界
        int border = 0;
        //记录最大下次跳跃的下标
        int maxPosition = 0;
        //记录跳跃的步数
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == border) {
                border = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}