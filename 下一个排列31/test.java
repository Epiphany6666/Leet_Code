package title.下一个排列31;

public class test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 5, 7, 6, 4};
        new Solution().nextPermutation(nums);
    }
}

/*
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2, j = len - 1;
        for (; i >= 0; i--, j--) {
            if (nums[i] > nums[j]) break;
        }

        int k = len - 1;
        for (; k >= 0; k--) {
            if (nums[k] > nums[i]) break;
        }

        swap(nums, i, k);

        reverse(nums, j);
    }

    private void reverse(int[] nums, int j) {
        int l = j, r = nums.length - 1;
        while (l < r) {
//            int t = nums[l];
//            nums[l] = nums[r];
//            nums[r] = t;
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }
}*/

//优化代码
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int j) {
        int l = j, r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }
}