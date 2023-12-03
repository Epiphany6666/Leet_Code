package title.颜色分类75;

import java.util.Arrays;

public class test {
}

//mind 主打一个叛逆哈哈哈
/*
class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}*/

//method 1：双指针
/*
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
        int p0 = 0, p1 = len - 1, i = 0;
        while (i <= p1) {
            if (nums[i] == 0) {
                swap(nums, p0, i);
                p0++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, p1);
                p1++;
            }
        }
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int t = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = t;
    }
}*/
