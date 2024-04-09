package title.正整数和负整数的最大计数2529;

public class test {
}

// method 1：直接遍历
class Solution1 {
    public int maximumCount(int[] nums) {
        int neg = 0, pos = 0;
        for (int num : nums) {
            if (num < 0) {
                neg++;
            } else if (num > 0) {
                pos++;
            }
        }
        return Math.max(neg, pos);
    }
}

/**
 * 参考题解：
 */
// method 2：二分查找
class Solution {
    public int maximumCount(int[] nums) {
        int neg = binary(nums, 0);
        int pos = nums.length - binary(nums, 1);
        return Math.max(neg, pos);
    }

    private int binary (int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        // 开区间不为空
        while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}