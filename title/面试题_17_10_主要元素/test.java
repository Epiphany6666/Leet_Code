package title.面试题_17_10_主要元素;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}*/

//mind 还有可能不存在。。。
/*class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums[nums.length / 2];
        int cnt = 0;
        for (int num : nums) {
            if (num == n) cnt++;
        }
//        return cnt >= nums.length / 2 ? n : -1;
        //note 超过才算。。。
        return cnt > nums.length / 2 ? n : -1;
    }
}*/

//摩尔投票法
/*
class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        int cnt = 0;
        int pre = nums[0];
        for (int num : nums) {
            if (num == pre) cnt++;
            else cnt--;
            if (cnt < 0) {
                pre = num;
                cnt = 0;
            }
        }
        for (int num : nums) {
            if (num == pre) cnt++;
        }
        return cnt > nums.length / 2 ? pre: -1;
    }
}*/

/*class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        int veto = 0;
        int x = 0;
        for (int num : nums) {
            if (veto == 0) x = num;
            veto += x == num ? 1 : -1;
        }
        veto = 0;
        for (int num : nums) {
            if (num == x) veto++;
        }
        return veto > nums.length / 2 ? x: -1;
    }
}*/

//method 2：哈希表