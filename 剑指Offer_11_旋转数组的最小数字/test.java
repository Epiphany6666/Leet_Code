package title.剑指Offer_11_旋转数组的最小数字;

import java.util.Arrays;

/**
 * 形参的参数名是可以改的！
 */
public class test {
}

/*
class Solution {
    public int minArray(int[] numbers) {
        return Arrays.stream(numbers).min().getAsInt();
    }
}*/

/*
class Solution {
    public int minArray(int[] nums) {
        int i = 0;
        int t = nums[0];
        for (i = 0; i < nums.length; i++) {
            if (t > nums[i]) {
                t = nums[i];
                break;
            }
            t = nums[i];
        }
        if (i == nums.length) {
            return nums[0];
        } else {
            return t;
        }
    }
}*/

//method 2:二分
class Solution {
    public int minArray(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[r]) {
//                r = mid - 1;
                //note 就是r=mid，没有-1！
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r -= 1;
            }
        }
        return nums[l];
    }
}