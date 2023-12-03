package title.寻找峰值162;

public class test {
}

/*
class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        if (nums[1] < nums[0]) return 0;
        if (nums[len - 1] > nums[len - 2]) return len - 1;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
        }
        return -1;
    }
}*/

//method 1：模拟
/*
//mind 官方的代码真的很简洁
class Solution {
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[idx]) idx = i;
        }
        return idx;
    }
}*/

//method 2：二分
//mind 这样子写的二分相对于我以前写的二分，不需要判断越界问题
/*
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}*/


class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[mid + 1]) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}