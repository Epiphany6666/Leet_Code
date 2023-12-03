package title.寻找旋转排序数组中的最小值153;

public class test {
    public static void main(String[] args) {
        new Solution().findMin(new int[] {4,5,6,7,0,1,2});
    }
}

/*
class Solution {
    public int findMin(int[] nums) {
        int idx = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) idx = i;
        }
        return idx == -1 ? 0 : idx;
    }
}*/

//method 二分查找
/*
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[l] < nums[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[l + 1];
    }
}*/

//method 只能比较中指和右值
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}