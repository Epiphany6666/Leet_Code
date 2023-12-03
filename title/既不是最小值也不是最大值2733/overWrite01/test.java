package title.既不是最小值也不是最大值2733.overWrite01;

import java.util.Arrays;
/**
 * 总结
 * public static void sort(int[] a, int fromIndex, int toIndex)：按升序对数组的指定范围进行排序。前闭后开。
 */

public class test {
}

/*
class Solution {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) return -1;
        Arrays.sort(nums);
        return nums[1];
    }
}*/

//只对前3个数进行排序！
class Solution {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) return -1;
        Arrays.sort(nums, 0, 3);
        return nums[1];
    }
}