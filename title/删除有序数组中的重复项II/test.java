package Leet_Code.删除有序数组中的重复项II;

public class test {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        System.out.println(new Solution().removeDuplicates(nums));
    }
}

/**
 * 错误原因：第一次的修改可能会影响到第二次
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) continue;
            nums[idx] = nums[i];
        }
        return idx;
    }
}

/**
 * 原来我一直都误解错了。。。nums[i] == nums[idx - 2]对比，而不是应该和nums[i - 2]对比
 * 并且题目都说是有序的了，就不需要比较三个数了。
 */
class Solution2 {
    public int removeDuplicates(int[] nums) {
        int idx = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[idx - 2]) continue;
            nums[idx] = nums[i];
        }
        return idx;
    }
}